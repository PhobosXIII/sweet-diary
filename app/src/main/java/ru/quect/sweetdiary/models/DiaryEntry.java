package ru.quect.sweetdiary.models;

public class DiaryEntry {
    private short mGlucose;

    /**
     * Constructs a new instance of DiaryEntry with the specified initial
     * blood sugar level in mg/dl units.
     * @param glucose the initial blood sugar level
     */
    public DiaryEntry(short glucose) {
        mGlucose = glucose;
    }

    /**
     * Returns blood sugar level in mg/dl units.
     *
     * @return blood sugar level
     */
    public short getGlucose() {
        return mGlucose;
    }

    /**
     * Set blood sugar level in mg/dl units.
     * @param glucose blood sugar level
     */
    public void setGlucose(short glucose) {
        mGlucose = glucose;
    }
}
