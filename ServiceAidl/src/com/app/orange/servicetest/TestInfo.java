package com.app.orange.servicetest;

import android.os.Parcel;
import android.os.Parcelable;

public class TestInfo implements Parcelable {

    String m_score;
    String m_name;

    public TestInfo() {

    }

    public TestInfo(String name, String score) {
        m_score = score;
        m_name = name;
    }

    public void set_name(String m_name) {
        this.m_name = m_name;
    }

    public void set_score(String m_score) {
        this.m_score = m_score;
    }

    public String get_name() {
        return m_name;
    }

    public String get_score() {
        return m_score;
    }

    public int describeContents() {
        return 0;
    }

    private void readFromParcel(Parcel in) {
        m_name = in.readString();
        m_score = in.readString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(m_name);
        dest.writeString(m_score);
    }

    protected TestInfo(Parcel in) {
        readFromParcel(in);
    }

    public static final Parcelable.Creator<TestInfo> CREATOR = new Parcelable.Creator<TestInfo>() {
        public TestInfo createFromParcel(Parcel source) {
            return new TestInfo(source);
        }

        public TestInfo[] newArray(int size) {
            return new TestInfo[size];
        }
    };
 }