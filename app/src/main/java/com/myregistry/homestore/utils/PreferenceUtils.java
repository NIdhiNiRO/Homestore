package com.myregistry.homestore.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by nidhiparekh.
 */

public final class PreferenceUtils {

    //used preference to maintain count app level, use the web service
    public static final String CART_COUNT = "COUNT";
    public static String PREF_NAME = "HomeStorePref";
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;

    public PreferenceUtils(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
    }

    public void setUserID(Context context, int UserID) {
        editor = sharedPreferences.edit();
        editor.putInt(CART_COUNT, UserID);
        editor.apply();
    }

    public int getUserID() {
        return sharedPreferences.getInt(CART_COUNT, 0);
    }


}
