package com.example.abhigyaan;

public class Volunteer {
    private String id;
    private String name;
    private String birthdate;

    public Volunteer() {
    }

    public Volunteer(String id, String name, String birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthdate() {
        return birthdate;
    }
}
