package zw.co.deepkah.voucher.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormatter {


    public static Date getDateFromString(String date) {

        try {
            if (date == null || date.isEmpty()) {
                return null;
            }

            SimpleDateFormat format = new SimpleDateFormat("d/M/yyyy");
            System.out.println("###-MY-DATE-"+format.parse(date));
            return format.parse(date);
        }catch (Exception ex){

        }

     return  null;
    }
    public static LocalDate getLocalDateFromString(String date) {

        if(date==null ||date.isEmpty()){
            return null;
        }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

        LocalDate localDate = LocalDate.parse(date,formatter);


        return localDate;
    }

    public static LocalDate getNotificationDate(String date){
        if(date==null || date.isEmpty()){
           return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM d yyyy");
        LocalDate localDate = LocalDate.parse(date,formatter);
        return localDate;
    }

    public static String getFormmatedLocalDate(LocalDate localDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM d yyyy");
        return  formatter.format(localDate);

    }
    public static String getFormmatedNormalFormat(LocalDate localDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        return  formatter.format(localDate);

    }
    public static LocalDate getLocalDateFromUtilDate(Date date) {

        if(date==null){
            return null;
        }
        ZoneId zoneId = ZoneId.of("Africa/Harare");

        LocalDate localDate = date.toInstant().atZone(zoneId).toLocalDate();


        return localDate;
    }

    public static String calculateEDD(String lmpDate){

        LocalDate lmpLocalDate = DateFormatter.getLocalDateFromString(lmpDate);
        LocalDate eddLocalDate = lmpLocalDate.plusDays(280);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        return eddLocalDate.format(formatter);

    }

    public static LocalDate expectedDateOfVisit(LocalDate today,int numberOfDays){

        return today.plusDays(numberOfDays);
    }
}