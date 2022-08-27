package com.screen;

public enum Properties {
    ACCOUNT1 (3.303e+23, 2.4397e6),
    ACCOUNT2   (4.869e+24, 6.0518e6);

    private final double email;   // in kilograms
    private final double password; // in meters
    Properties(double email, double password) {
        this.email = email;
        this.password = password;
    }
}
