package com.cdh.sms.tools;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by cc on 16-11-18.
 */

public class SharedPreferencesHelper {
    private SharedPreferences sharedPreferences;
    private static final String FILE_NAME = "com.example.myapp.PREFERENCE_FILE_KEY";
    private static final String FIRST_ACCESS = "first_access";

    private static final String SANDWICH = "sandwich";
    private static final String PRICE = "price";

    public SharedPreferencesHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(FILE_NAME, context.MODE_PRIVATE);
    }

    public boolean isFirstAccess() {
        return sharedPreferences.getBoolean(FIRST_ACCESS, true);
    }

    public void setFirstAccess(boolean firstAccess) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(FIRST_ACCESS, firstAccess);
        editor.commit();
    }

    public void setLastSandwich(String sandwich, float price) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(SANDWICH, sandwich);
        editor.putFloat(PRICE, price);
        editor.commit();
    }

    public String getSandwich() {
        return sharedPreferences.getString(SANDWICH, "");
    }
    public float getPrice() {
        return sharedPreferences.getFloat(PRICE, 0f);
    }
}
