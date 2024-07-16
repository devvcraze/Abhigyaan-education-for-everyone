package com.example.abhigyaan;

public class MainModel_disha {

    private String name;
    private String clas;
    private String update;
    private String surl;

    // Default constructor required for calls to DataSnapshot.getValue(MainModel_disha.class)
    public MainModel_disha() {
    }

    // Parameterized constructor
    public MainModel_disha(String name, String clas, String update, String surl) {
        this.name = name;
        this.clas = clas;
        this.update = update;
        this.surl = surl;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }
}
