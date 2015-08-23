package ru.quect.sweetdiary.models;

public class DiaryEntry {
    private double mGlucose;

    public DiaryEntry(double glucose) {
        mGlucose = glucose;
    }

    public double getGlucose() {
        return mGlucose;
    }

    public void setGlucose(double glucose) {
        mGlucose = glucose;
    }
}
