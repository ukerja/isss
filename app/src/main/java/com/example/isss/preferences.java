package com.example.isss;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class preferences {
    private static final String DATA_LOGIN = "status_login",
            DATA_AS = "as";

    private static SharedPreferences getSharePreferences(Context context){
            return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setDataAs (Context context, String data){
        SharedPreferences.Editor editor =getSharePreferences(context).edit();
        editor.putString(DATA_AS,data);
        editor.apply();
    }
    public static String getDataAs (Context context){
        return getSharePreferences(context).getString(DATA_AS,"");

    }
    public static void setDataLogin (Context context, boolean status){
        SharedPreferences.Editor editor = getSharePreferences(context).edit();
        editor.putBoolean(DATA_LOGIN, status);
        editor.apply();

    }
    public static boolean getDataLogin(Context context){
        return getSharePreferences(context).getBoolean(DATA_LOGIN, false);

    }

    public static void clearData(Context context){
        SharedPreferences.Editor editor = getSharePreferences(context).edit();
        editor.remove(DATA_AS);
        editor.remove(DATA_LOGIN);
        editor.apply();
    }


}
