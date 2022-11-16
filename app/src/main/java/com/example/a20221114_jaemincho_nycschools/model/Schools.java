package com.example.a20221114_jaemincho_nycschools.model;

import com.google.gson.annotations.SerializedName;

public class Schools {
    private String dbn;
    @SerializedName("school_name")
    private String schoolName;
    @SerializedName("num_of_sat_test_takers")
    private String numOfSatTestTakers;
    @SerializedName("sat_critical_reading_avg_score")
    private String satCriticalThinkingReadingAvgScore;
    @SerializedName("sat_math_avg_score")
    private String satMathAvgScore;
    @SerializedName("sat_writing_avg_score")
    private String satWritingAvgScore;

    public String getDbn() {
        return dbn;
    }

    public void setDbn(String dbn) {
        this.dbn = dbn;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getNumOfSatTestTakers() {
        return numOfSatTestTakers;
    }

    public void setNumOfSatTestTakers(String numOfSatTestTakers) {
        this.numOfSatTestTakers = numOfSatTestTakers;
    }

    public String getSatCriticalThinkingReadingAvgScore() {
        return satCriticalThinkingReadingAvgScore;
    }

    public void setSatCriticalThinkingReadingAvgScore(String satCriticalThinkingReadingAvgScore) {
        this.satCriticalThinkingReadingAvgScore = satCriticalThinkingReadingAvgScore;
    }

    public String getSatMathAvgScore() {
        return satMathAvgScore;
    }

    public void setSatMathAvgScore(String satMathAvgScore) {
        this.satMathAvgScore = satMathAvgScore;
    }

    public String getSatWritingAvgScore() {
        return satWritingAvgScore;
    }

    public void setSatWritingAvgScore(String satWritingAvgScore) {
        this.satWritingAvgScore = satWritingAvgScore;
    }
}
