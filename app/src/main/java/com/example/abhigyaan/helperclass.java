package com.example.abhigyaan;

public class helperclass {
    String name,username,email,phone,password_toggle;

    public helperclass() {

    }

    public helperclass(String name, String username, String email, String phone, String password_toggle) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password_toggle = password_toggle;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword_toggle() {
        return password_toggle;
    }
}
