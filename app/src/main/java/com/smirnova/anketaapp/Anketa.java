package com.smirnova.anketaapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Anketa implements Parcelable {
    private String userName;
    String lastName;
    String phone;
    String site;
    String adress;


    public Anketa (){
        userName="";
        lastName="";
        phone="";
        site="";
        adress="";
    }


    protected Anketa(Parcel in) {
        userName = in.readString();
        lastName = in.readString();
        phone = in.readString();
        site = in.readString();
        adress = in.readString();
    }

    public static final Creator<Anketa> CREATOR = new Creator<Anketa>() {
        @Override
        public Anketa createFromParcel(Parcel in) {
            return new Anketa(in);
        }

        @Override
        public Anketa[] newArray(int size) {
            return new Anketa[size];
        }
    };

    /*   public Anketa(String userName, String lastName, String phone, String site, String adress) {
            this.userName = userName;
            this.lastName = lastName;
            this.phone = phone;
            this.site = site;
            this.adress = adress;
        }
    */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getUserName() {
        return userName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getSite() {
        return site;
    }

    public String getAdress() {
        return adress;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(userName);
        parcel.writeString(lastName);
        parcel.writeString(phone);
        parcel.writeString(site);
        parcel.writeString(adress);


    }
}
