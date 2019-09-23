package br.com.miller.testeAndroid.utils;

import android.support.design.widget.TextInputEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;


public class Mask {

    public static final String FORMAT_PHONE1 = "(##) #####-####";
    public static final String FORMAT_PHONE2 = "(##) ####-####";


    /**
     * Método que realiza a formatação de acordo com o formato desejado
     * @param editText Edit text a ser formatado
     * @return
     */

    public static TextWatcher mask (final TextInputEditText editText) {

        return new TextWatcher() {

            boolean isUpdating;
            String old = "";

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

                final String str = Mask.unmask(charSequence.toString());
                String maskeradeString = "";

                if( isUpdating ){

                    old = str;
                    isUpdating = false;
                    return;
                }

                int i = 0;

                String mask;

                if(str.length() <= 10){
                    mask = FORMAT_PHONE2;
                }else{
                    mask =FORMAT_PHONE1;
                }

                for (final char m: mask.toCharArray()){

                    if( m != '#' && str.length() > old.length()){
                       maskeradeString += m;
                       continue;
                    }
                    try{
                        maskeradeString += str.charAt(i);
                    }catch (final  Exception e){
                        break;
                    }
                    i++;
                }

                isUpdating = true;
                editText.setText(maskeradeString);
                editText.setSelection(maskeradeString.length());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
    }

    public static String unmask(final String s) {
        return s.replaceAll("[.]", "").replaceAll("[-]", "").replaceAll("[/]", "").replaceAll("[(]", "").replaceAll("[ ]","").replaceAll("[:]", "").replaceAll("[)]", "");
    }
}
