package com.spring.dao.model.enums;

public enum UserStatus {
    ACTIVE("ACTIVE"),
    DISABLED("DISABLED");

    private final String status;

    UserStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}