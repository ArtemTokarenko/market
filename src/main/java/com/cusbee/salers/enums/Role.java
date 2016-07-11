package com.cusbee.salers.enums;

public enum Role {

    /*0*/ROLE_SALER("Saler"),
    /*1*/ROLE_ADMIN("Admin");

    private String description;

    public String getDescription() {
        return description;
    }

    Role(String description) {
        this.description = description;
    }
}