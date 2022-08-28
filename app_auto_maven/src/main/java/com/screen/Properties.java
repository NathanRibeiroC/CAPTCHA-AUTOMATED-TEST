package com.screen;

public enum Properties {
    ACCOUNT1 ("elianasants22@gmail.com", "b569da99"),
    ACCOUNT2   ("danworkhoff@gmail.com", "ZBw%0Y8j0W90");

    private final String email;   // in kilograms
    private final String password; // in meters
    Properties(String email, String password) {
        this.email = email;
        this.password = password;
    }

    String getEmail(){
        return email;
    }

    String getPassword(){
        return password;
    }
}
