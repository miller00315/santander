package br.com.miller.testeAndroid.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionCheck {

    /**
     * Metodo que para verificar se existe conexão de rede
     * @return estado da conexão
     */

    public static ConnectionCheck newInstance(){

        return new ConnectionCheck();

    }

    public boolean isNetworkAvailable(Context context) {

        try {
            ConnectivityManager connectivityManager = (ConnectivityManager)
                    context.getSystemService(Context.CONNECTIVITY_SERVICE);

            if (connectivityManager != null) {
                NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
                return activeNetwork != null && activeNetwork.isConnected();
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }

    }
}
