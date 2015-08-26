package ru.quect.sweetdiary;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Utils {
    public static final float GLUCOSE_CONVERT_KOEF = 18;
    private Utils() {

    }

    public static boolean isGlucoseSI(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(context.getString(R.string.glucose_units_key),
                context.getString(R.string.glucose_units_si))
                .equals(context.getString(R.string.glucose_units_si));
    }

    public static String formatGlucose(Context context, short glucose) {
        if (isGlucoseSI(context)) {
            float glucoseSI = glucose / GLUCOSE_CONVERT_KOEF;
            return context.getString(R.string.format_glucose_si, glucoseSI);
        }
        else {
            return context.getString(R.string.format_glucose_traditional, glucose);
        }

    }
}
