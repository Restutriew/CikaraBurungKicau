package com.cikarastudio.cikaraburungkicau.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Burung implements Parcelable {

    private String namaBurung;
    private String deskripsiBurung;
    private Integer fotoBurung;
    private Integer audioBurung;


    public Burung(String namaBurung, String deskripsiBurung, Integer fotoBurung, Integer audioBurung) {
        this.namaBurung = namaBurung;
        this.deskripsiBurung = deskripsiBurung;
        this.fotoBurung = fotoBurung;
        this.audioBurung = audioBurung;
    }

    public Burung() {

    }

    public String getNamaBurung() {
        return namaBurung;
    }

    public void setNamaBurung(String namaBurung) {
        this.namaBurung = namaBurung;
    }

    public String getDeskripsiBurung() {
        return deskripsiBurung;
    }

    public void setDeskripsiBurung(String deskripsiBurung) {
        this.deskripsiBurung = deskripsiBurung;
    }

    public Integer getFotoBurung() {
        return fotoBurung;
    }

    public void setFotoBurung(Integer fotoBurung) {
        this.fotoBurung = fotoBurung;
    }

    public Integer getAudioBurung() {
        return audioBurung;
    }

    public void setAudioBurung(Integer audioBurung) {
        this.audioBurung = audioBurung;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(namaBurung);
        parcel.writeString(deskripsiBurung);
        if (fotoBurung == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(fotoBurung);
        }
        if (audioBurung == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(audioBurung);
        }
    }

    protected Burung(Parcel in) {
        namaBurung = in.readString();
        deskripsiBurung = in.readString();
        if (in.readByte() == 0) {
            fotoBurung = null;
        } else {
            fotoBurung = in.readInt();
        }
        if (in.readByte() == 0) {
            audioBurung = null;
        } else {
            audioBurung = in.readInt();
        }
    }

    public static final Creator<Burung> CREATOR = new Creator<Burung>() {
        @Override
        public Burung createFromParcel(Parcel in) {
            return new Burung(in);
        }

        @Override
        public Burung[] newArray(int size) {
            return new Burung[size];
        }
    };
}
