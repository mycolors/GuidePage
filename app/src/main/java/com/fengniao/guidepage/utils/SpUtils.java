package com.fengniao.guidepage.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.health.ServiceHealthStats;

/**
 * SharesPreference工具类
 */

public class SpUtils {
    private static final String spFileName = "app";

    public static String getString(Context context, String strKey) {
        SharedPreferences setPreferences = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        return setPreferences.getString(strKey, "");
    }

    public static String getString(Context context, String strKey, String strDefault) {
        SharedPreferences setPreferences = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        return setPreferences.getString(strKey, strDefault);
    }

    public static void putString(Context context, String strKey, String strData) {
        SharedPreferences activityPreferences = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = activityPreferences.edit();
        editor.putString(strKey, strData);
        editor.apply();
    }

    public static Boolean getBoolean(Context context, String strKey) {
        SharedPreferences setPreferences = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        return setPreferences.getBoolean(strKey, false);
    }

    public static Boolean getBoolean(Context context, String strKey,
                                     Boolean booDefault) {
        SharedPreferences setPreferences = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        return setPreferences.getBoolean(strKey, booDefault);
    }

    public static void putBoolean(Context context, String strKey,
                                  Boolean booData) {
        SharedPreferences activityPreferences = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = activityPreferences.edit();
        editor.putBoolean(strKey, booData);
        editor.apply();
    }

    public static int getInt(Context context, String strKey) {
        SharedPreferences setPreferences = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        return setPreferences.getInt(strKey, -1);
    }

    public static int getInt(Context context, String strKey,
                             int intDefault) {
        SharedPreferences setPreferences = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        return setPreferences.getInt(strKey, intDefault);
    }


    public static void putInt(Context context, String strKey,
                              int intData) {
        SharedPreferences activityPreferences = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = activityPreferences.edit();
        editor.putInt(strKey, intData);
        editor.apply();
    }


    public static long getLong(Context context, String strKey) {
        SharedPreferences setSharePreference = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        return setSharePreference.getLong(strKey, -1);
    }

    public static long getLong(Context context, String strKey,
                               long longDefault) {
        SharedPreferences setSharePreference = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        return setSharePreference.getLong(strKey, longDefault);
    }

    public static void putLong(Context context, String strKey,
                               long longData) {
        SharedPreferences activityPreferences = context.getSharedPreferences(
                spFileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = activityPreferences.edit();
        editor.putLong(strKey, longData);
        editor.apply();
    }


}
