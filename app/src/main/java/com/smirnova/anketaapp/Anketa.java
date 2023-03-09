package com.smirnova.anketaapp;

public class Anketa {
    String userName;
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

  /*
    public Anketa(String userName, String lastName, String phone, String site, String adress) {
        this.userName = userName;
        this.lastName = lastName;
        this.phone = phone;
        this.site = site;
        this.adress = adress;
    }*/

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
}
