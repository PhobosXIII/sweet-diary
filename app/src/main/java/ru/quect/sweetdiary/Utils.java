package ru.quect.sweetdiary;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Utils {
    private Utils() {

    }

    public static boolean isGlucoseSI(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(context.getString(R.string.glucose_units_key),
                context.getString(R.string.glucose_units_si))
                .equals(context.getString(R.string.glucose_units_si));
    }

    public static String formatGlucose(Context context, double glucose) {
        if (!isGlucoseSI(context)) {
            glucose = glucose * 18;
        }
        return context.getString(R.string.format_glucose, glucose);
    }
}
