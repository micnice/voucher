package zw.co.deepkah.voucher.scheduler;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import zw.co.deepkah.voucher.document.BeneficiaryIdentification;
import zw.co.deepkah.voucher.document.Sales;
import zw.co.deepkah.voucher.service.BeneficiaryIdentificationService;
import zw.co.deepkah.voucher.service.SalesService;
import zw.co.deepkah.voucher.util.DateFormatter;
import zw.co.deepkah.voucher.util.PhoneNumberFormatter;
import zw.co.deepkah.voucher.util.RestTemplateUtil;
import zw.co.deepkah.voucher.util.TextMessageUtil;

import java.time.LocalDate;
import java.util.Date;

@Component
public class ReminderNotificationService {

    @Autowired
   private SalesService salesService;
    private static final Logger log = LoggerFactory.getLogger(ReminderNotificationService.class);

    @Autowired
    BeneficiaryIdentificationService bis;

   // @Scheduled(fixedDelay = 7200000)
   @Scheduled(fixedDelay = 120000)
    private void sendANCVisitReminder(){
        try {

            for(Sales sales:salesService.findAll().get()){
                System.out.println("$$$$$--ANC1"+sales.getAncVisitOneDate()+"-"+sales.getAnc1Notified());
                System.out.println("$$$$$--ANC2"+sales.getAncVisitTwoDate());
                BeneficiaryIdentification bi = bis.getOne(sales.getBeneficiaryIdentityId()).get();
                LocalDate today = LocalDate.now();
                if(bi!=null && bi.getPhoneNumber()!=null){
                    //ANC VISIT 2
                if(!sales.getAnc2Notified() &&sales.getAncVisitOneDate()!=null && sales.getAncVisitTwoDate() ==null){
                  {
                      LocalDate ancVisitOneDate = DateFormatter.getLocalDateFromString(sales.getAncVisitOneDate());

                      int numberOfDays = today.getDayOfYear()-ancVisitOneDate.getDayOfYear();
                      //TODO LIVE LIVE
                     // LocalDate expectedDateOfVisit =DateFormatter.expectedDateOfVisit(today,28-numberOfDays);
                      LocalDate expectedDateOfVisit =DateFormatter.expectedDateOfVisit(today,3);
                      System.out.println("&&&&&&&&&--ANCVISITONE-"+sales.getAncVisitOneDate());
                     // if(numberOfDays>=25){
                       if(numberOfDays==0){
                          MultiValueMap<String, String> map = TextMessageUtil.getTxtMessageUtils();
                          //TODO LIVE LIVE
//                          String message = TextMessageUtil.getANC2NotificationMessage(expectedDateOfVisit,bi.getFirstName()+" "+bi.getLastName()
//                          ,28-numberOfDays);
                          String message = TextMessageUtil.getANC2NotificationMessage(expectedDateOfVisit,bi.getFirstName()+" "+bi.getLastName()
                                  ,3);
                          map.add("mobile", PhoneNumberFormatter.formatPhoneNumber(bi.getPhoneNumber()));
                          map.add("message", message);
                          RestTemplateUtil.postData(map);

                          sales.setAnc2Notified(Boolean.TRUE);
                          salesService.save(sales);
                      }
                  }

                   }


                    //ANC VISIT 3
                    if(!sales.getAnc3Notified() &&sales.getAncVisitTwoDate()!=null && sales.getAncVisitThreeDate() ==null){
                        {
                            LocalDate ancVisitTwoDate = DateFormatter.getLocalDateFromString(sales.getAncVisitTwoDate());

                            int numberOfDays = today.getDayOfYear()-ancVisitTwoDate.getDayOfYear();

                            LocalDate expectedDateOfVisit =DateFormatter.expectedDateOfVisit(today,28-numberOfDays);

                            if(numberOfDays>=25){
                                MultiValueMap<String, String> map = TextMessageUtil.getTxtMessageUtils();
                          String message = TextMessageUtil.getANC3NotificationMessage(expectedDateOfVisit,bi.getFirstName()+" "+bi.getLastName()
                          ,28-numberOfDays);

                                map.add("mobile", PhoneNumberFormatter.formatPhoneNumber(bi.getPhoneNumber()));
                                map.add("message", message);
                                RestTemplateUtil.postData(map);

                                sales.setAnc3Notified(Boolean.TRUE);
                                salesService.save(sales);
                            }
                        }

                    }
                    //ANC VISIT 4
                    if(!sales.getAnc4Notified() &&sales.getAncVisitThreeDate()!=null && sales.getAncVisitFourDate() ==null){
                        {
                            LocalDate ancVisitThreeDate = DateFormatter.getLocalDateFromString(sales.getAncVisitThreeDate());

                            int numberOfDays = today.getDayOfYear()-ancVisitThreeDate.getDayOfYear();

                            LocalDate expectedDateOfVisit =DateFormatter.expectedDateOfVisit(today,28-numberOfDays);

                            if(numberOfDays>=25){
                                MultiValueMap<String, String> map = TextMessageUtil.getTxtMessageUtils();
                                String message = TextMessageUtil.getANC4NotificationMessage(expectedDateOfVisit,bi.getFirstName()+" "+bi.getLastName()
                                        ,28-numberOfDays);

                                map.add("mobile", PhoneNumberFormatter.formatPhoneNumber(bi.getPhoneNumber()));
                                map.add("message", message);
                                RestTemplateUtil.postData(map);

                                sales.setAnc4Notified(Boolean.TRUE);
                                salesService.save(sales);
                            }
                        }

                    }

                    //PNC 7 Days
                    if(!sales.getPnc7DaysNotified() &&sales.getPnc6weeksVisitDate()==null && sales.getDateOfDelivery()!=null){
                        {
                            LocalDate dateOfDelivery = DateFormatter.getLocalDateFromString(sales.getDateOfDelivery());

                            int numberOfDays = today.getDayOfYear()-dateOfDelivery.getDayOfYear();

                            LocalDate expectedDateOfVisit =DateFormatter.expectedDateOfVisit(today,7-numberOfDays);

                            if(numberOfDays>=4){
                                MultiValueMap<String, String> map = TextMessageUtil.getTxtMessageUtils();
                                String message = TextMessageUtil.getPNC7DaysNotificationMessage(expectedDateOfVisit,bi.getFirstName()+" "+bi.getLastName());

                                map.add("mobile", PhoneNumberFormatter.formatPhoneNumber(bi.getPhoneNumber()));
                                map.add("message", message);
                                RestTemplateUtil.postData(map);

                                sales.setPnc7DaysNotified(Boolean.TRUE);
                                salesService.save(sales);
                            }
                        }

                    }
                    //PNC 6 weeks
                    if(!sales.getPnc6weeksNotified() &&sales.getPnc6weeksVisitDate()==null && sales.getDateOfDelivery()!=null){
                        {
                            LocalDate dateOfDelivery = DateFormatter.getLocalDateFromString(sales.getDateOfDelivery());

                            int numberOfDays = today.getDayOfYear()-dateOfDelivery.getDayOfYear();

                            LocalDate expectedDateOfVisit =DateFormatter.expectedDateOfVisit(today,42-numberOfDays);

                            if(numberOfDays>=39){
                                MultiValueMap<String, String> map = TextMessageUtil.getTxtMessageUtils();
                                String message = TextMessageUtil.getPNC6WeeksDaysNotificationMessage(expectedDateOfVisit,bi.getFirstName()+" "+bi.getLastName());

                                map.add("mobile", PhoneNumberFormatter.formatPhoneNumber(bi.getPhoneNumber()));
                                map.add("message", message);
                                RestTemplateUtil.postData(map);

                                sales.setPnc6weeksNotified(Boolean.TRUE);
                                salesService.save(sales);
                            }
                        }

                    }

                }


            }


        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
