package zw.co.deepkah.voucher.util;

/**
 * Created by morris
 */
public class PhoneNumberFormatter {

    public static String formatPhoneNumber(String phoneNumber){

        if(phoneNumber.trim().startsWith("+263")){
            return phoneNumber.replaceFirst("/+","").trim();
        }else if(phoneNumber.trim().startsWith("0")){
            return phoneNumber.replaceFirst("0","263").trim();
        }else if(phoneNumber.trim().startsWith("7")){
            return phoneNumber.replaceFirst("7","2637").trim();
        }
        else {
            return  phoneNumber;
        }



    }
}
