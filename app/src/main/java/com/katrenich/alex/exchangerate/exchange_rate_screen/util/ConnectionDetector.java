package com.katrenich.alex.exchangerate.exchange_rate_screen.util;

import android.app.Service;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionDetector {

    public static boolean hasInternetConnection(Context context){
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Service.CONNECTIVITY_SERVICE);
        if(connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if(info != null){
                if (info.getDetailedState() == NetworkInfo.DetailedState.CONNECTED){
                    return true;
                }
            }
        }

        return false;
    }
}
