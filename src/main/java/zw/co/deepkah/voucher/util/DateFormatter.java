package zw.co.deepkah.voucher.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatter {


    public static LocalDate getDateFromString(String date) {

        if(date==null ||date.isEmpty()){
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

        LocalDate localDate = LocalDate.parse(date, formatter);

        return localDate;
    }
}