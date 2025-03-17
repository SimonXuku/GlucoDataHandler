package com.eveningoutpost.dexdrip.services.broadcastservice.models;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
//import lombok.Setter;
@Keep
public class Settings implements Parcelable {
    public static final Creator<Settings> CREATOR = new Creator<Settings>() {
        @Override
        public Settings createFromParcel(Parcel in) {
            return new Settings(in);
        }
        @Override
        public Settings[] newArray(int size) {
            return new Settings[size];
        }
    };
    //   @Setter
    private long graphStart;
    private long graphEnd;
    private final String apkName;
    private final boolean displayGraph;

    public Settings(Parcel in) {
        apkName = in.readString();
        graphStart = in.readLong();
        graphEnd = in.readLong();
        displayGraph = in.readInt() == 1;
    }

    public Settings() {
        apkName = "";
        displayGraph = false;
    }

    public Settings(String appName) {
        apkName = appName;
        displayGraph = false;
    }

    public Settings(String appName, long graphDurationMs) {
        apkName = appName;
        displayGraph = true;
        graphStart = graphDurationMs;
        graphEnd = 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(apkName);
        parcel.writeLong(graphStart);
        parcel.writeLong(graphEnd);
        parcel.writeInt(displayGraph ? 1 : 0);
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public long getGraphStart() {
        return this.graphStart;
    }

    @SuppressWarnings("all")
    public long getGraphEnd() {
        return this.graphEnd;
    }

    @SuppressWarnings("all")
    public boolean isDisplayGraph() {
        return this.displayGraph;
    }
    //</editor-fold>
}