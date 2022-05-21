package com.example.learningcenter.utill.enums;

public enum Day {
    SUNDAY("YAKSHANBA"),
    MONDAY("DUSHANBA"),
    TUESDAY("SESHANBA"),
    WEDNESDAY("CHORSHANBA"),
    THURSDAY("PAYSHANBA"),
    FRIDAY("JUMA"),
    SATURDAY("SHANBA");

    Day(String uz) {
        this.uz = uz;
    }

    private String uz;

    public String getUz() {
        return uz;
    }
}
