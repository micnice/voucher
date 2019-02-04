package zw.co.deepkah.voucher.util;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Date;
import java.time.LocalDate;

import static zw.co.deepkah.voucher.util.DateFormatter.getFormmatedLocalDate;
import static zw.co.deepkah.voucher.util.DateFormatter.getLocalDateFromString;
import static zw.co.deepkah.voucher.util.DateFormatter.getNotificationDate;

/**
 * Created by morris
 */
public class TextMessageUtil {

    public static MultiValueMap<String, String> getTxtMessageUtils(){

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("user","263777807782");
        map.add("password","zvinaiye");
        map.add("senderid","BVR");

      return map;
    }
    public static String getANC2NotificationMessage(LocalDate expectedDateOfVisit,String fullName,int numberOfDays){

       String message = "";
       if(numberOfDays!=0) {
           message = "Dear " + fullName + " Your Next ANC visit  ie (ANC 2nd Visit) is due in " + numberOfDays + " days time from today, that is on " + getFormmatedLocalDate(expectedDateOfVisit) + ". Good Day.";
       }else{
           message = "Dear " + fullName + " Your Next ANC visit ie (ANC 2nd Visit) is due today. Good Day.";

       }
        return message;
    }
    public static String getVoucherSaleNotificationMessage(String fullName, String edd){

        LocalDate eddLocalDate = getLocalDateFromString(edd);
        String message = "Dear "+fullName+" Please go to the nearest clinic and book for Antenatal Care Services within 3 days. Your Expected Date Of Delivery" +
                "(EDD) is on "+getFormmatedLocalDate(eddLocalDate);

        return message;
    }
    public static String getANC3NotificationMessage(LocalDate expectedDateOfVisit,String fullName, int numberOfDays){

        String message = "";
        if(numberOfDays!=0) {
            message = "Dear " + fullName + " Your Next ANC Visit ie (ANC 3rd Visit) is due in " + numberOfDays + " days time from today, that is on " +getFormmatedLocalDate(expectedDateOfVisit) + ". Good Day.";
        }else {
            message = "Dear " + fullName + " Your Next ANC Visit ie (ANC 3rd Visit) is due TODAY + . Good Day.";

        }
        return message;
    }
    public static String getANC4NotificationMessage(LocalDate expectedDateOfVisit,String fullName, int numberOfDays){

        String message = "";
        if(numberOfDays!=0){
          message="Dear "+fullName+" Your Next ANC Visit ie(ANC 4th Visit)is due in "+numberOfDays+" days time from today, that is on " +getFormmatedLocalDate(expectedDateOfVisit)+". Good Day." ;
        }else{
         message= "Dear "+fullName+" Your Next ANC Visit ie(ANC 4th Visit)is due today. Good Day." ;

        }


        return message;
    }
    public static String getPNC7DaysNotificationMessage(LocalDate expectedDateOfVisit,String fullName){


        String message = "Dear "+fullName+" Please Remember To Attend Your 7 Days Post Natal Care on "+getFormmatedLocalDate(expectedDateOfVisit)+". Good Day.";

        return message;
    }
    public static String getPNC6WeeksDaysNotificationMessage(LocalDate expectedDateOfVisit,String fullName){


        String message = "Dear "+fullName+" Please Remember To Attend Your 6 Weeks Post Natal Care on "+getFormmatedLocalDate(expectedDateOfVisit)+". Good Day.";

        return message;
    }

    public static String getOTP(String fullName,String voucherAmount,String password){

       String message ="Dear "+fullName+ " password for the claiming of the $"+voucherAmount+" voucher is:"+password+". Please show " +
               "this message to the person attending to you and get your $"+voucherAmount+" before you leave this place.";

       return message;
    }


}
