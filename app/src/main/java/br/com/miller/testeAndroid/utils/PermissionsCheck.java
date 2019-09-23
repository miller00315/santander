package br.com.miller.testeAndroid.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

public class PermissionsCheck {

    private String[] permissions;
    public static int P_CODE = 433;

    public static PermissionsCheck newInstace(){

        return new PermissionsCheck();

    }

    public void setPermissions() {

        this.permissions = new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.INTERNET,
        };

    }

    public boolean checkSelfPermissions(Activity act){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

            boolean allowed = true;

            for(String s: permissions){

                if(ActivityCompat.checkSelfPermission(act, s) != PackageManager.PERMISSION_GRANTED)
                    allowed = false;

            }

            return allowed;

        }else{
            return true;
        }
    }

    public void requestSelfPermission(Activity act){
        ActivityCompat.requestPermissions(act, permissions, P_CODE);
    }

}
