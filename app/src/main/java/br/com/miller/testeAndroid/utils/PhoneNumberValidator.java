package br.com.miller.testeAndroid.utils;
import android.telephony.PhoneNumberUtils;

import java.util.regex.Pattern;

public class PhoneNumberValidator {

    public static final Pattern PHONE_PATTERN = Pattern.compile(
            "[0-9\\-\\+]{10,13}"
    );

    public static  boolean isPhoneNumber(String stringPhone){

        try{

            return  stringPhone != null && PHONE_PATTERN.matcher(stringPhone).matches();

        }catch (NumberFormatException nfe){
            return false;
        }catch(NullPointerException npe){
            return false;
        }
    }


}
