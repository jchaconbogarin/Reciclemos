package itcr.reciclemos.gameutilities;

import android.content.SharedPreferences;

/**
 * Created by Boga on 20.04.2016.
 */
public class Progress {

    public static final String PREFERENCES_VALUE = "PROGRESS";
    public static final String INFORMATION = "INFORMATION";
    public static final String HOUSE = "HOUSE";
    public static final String LAKE = "LAKE";

    public static boolean getInformation(SharedPreferences sp) {
        return getPreference(sp, Progress.INFORMATION);
    }

    public static boolean getHouse(SharedPreferences sp) {
        return getPreference(sp, Progress.HOUSE);
    }

    public static boolean getLake(SharedPreferences sp) {
        return getPreference(sp, Progress.LAKE);
    }

    public static void setInformationCompleted(SharedPreferences sp) {
        editPreference(sp, Progress.INFORMATION, true);
    }

    public static void setHouseCompleted(SharedPreferences sp) {
        editPreference(sp, Progress.HOUSE, true);
    }

    public static void setLakeCompleted(SharedPreferences sp) {
        editPreference(sp, Progress.LAKE, true);
    }

    private static void editPreference(SharedPreferences sp, String field, boolean value) {
        sp.edit().putBoolean(field, value).apply();
    }

    private static boolean getPreference(SharedPreferences sp, String field) {
        return sp.getBoolean(field, false);
    }

    public static void resetAll(SharedPreferences sp) {
        sp.edit().putBoolean(Progress.INFORMATION, false).apply();
        sp.edit().putBoolean(Progress.LAKE, false).apply();
        sp.edit().putBoolean(Progress.HOUSE, false).apply();
    }

}
