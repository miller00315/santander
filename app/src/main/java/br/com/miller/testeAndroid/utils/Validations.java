package br.com.miller.testeAndroid.utils;

import android.support.design.widget.TextInputEditText;
import android.util.Patterns;

import java.util.Objects;

public class Validations {

    private boolean[] validates;

    public Validations() {
        validates = new boolean[3];

    }

    public void nameValidation(TextInputEditText nameEditText){

        String name = Objects.requireNonNull(nameEditText.getText()).toString().trim();

        if(name.isEmpty()){

            nameEditText.setError("Nome não pode esta vázio");
            validates[0] = false;

        } else if(!name.matches("^[a-zA-Z]+(?:[\\s.]+[a-zA-Z]+)*$")){

            nameEditText.setError("Nome não ter numeros ou caracters especiais");
            validates[0] = false;

        }else{
            nameEditText.setError(null);
            validates[0] = true;
        }
    }

    public void emailValidation(TextInputEditText emailEditText){

        String email = Objects.requireNonNull(emailEditText.getText()).toString().trim();

        if(email.isEmpty()){
            emailEditText.setError("E-mail não pode ficar vazio");
            validates[1] = false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("E-mail inválido");
            validates[1] = false;
        }else{
            emailEditText.setError(null);
            validates[1] = true;
        }
    }

    public void phoneValidation(TextInputEditText phoneEditText){

        String phone = Objects.requireNonNull(phoneEditText.getText()).toString().trim();

        if(phone.isEmpty()){
            phoneEditText.setError("Telefone não pode ficar vazio");
            validates[2] = false;
        }

        phone = Mask.unmask(phone);

        if(!phone.matches("^[+]?[0-9]{10,13}$")){
            phoneEditText.setError("Telefone inválido");
            validates[2] = false;
        } else{
            phoneEditText.setError(null);
            validates[2] = true;
        }
    }

    public boolean[] getValidates() {
        return validates;
    }
}
