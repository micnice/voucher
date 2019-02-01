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

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
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
//        ZoneId zoneId = ZoneId.of("Africa/Harare");
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

        LocalDate localDate = LocalDate.parse(date);


        return localDate;
    }

    public static LocalDate getLocalDateFromUtilDate(Date date) {

        if(date==null){
            return null;
        }
        ZoneId zoneId = ZoneId.of("Africa/Harare");

        LocalDate localDate = date.toInstant().atZone(zoneId).toLocalDate();


        return localDate;
    }

    public static Date calculateEDD(Date lmpDate){

        System.out.println("@@@-LMPRAW--"+lmpDate);
        LocalDate lmpLocalDate = DateFormatter.getLocalDateFromUtilDate(lmpDate);
        System.out.println("@@@-LMPLOCAL--"+lmpLocalDate);
        LocalDate eddLocalDate = lmpLocalDate.plusDays(280);
        ZoneId zoneId = ZoneId.of("Africa/Harare");
        return Date.from(lmpLocalDate.atStartOfDay(zoneId).toInstant());

    }

    public static LocalDate expectedDateOfVisit(LocalDate today,int numberOfDays){

        return today.plusDays(numberOfDays);
    }
}