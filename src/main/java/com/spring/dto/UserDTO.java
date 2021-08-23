package com.spring.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class UserDTO {
    @Getter
    @Setter
    private UUID id;

    @Getter
    @Setter
    private String user_email;

    @Getter
    @Setter
    private String user_password;

    @Getter
    @Setter
    private String firstname;

    @Getter
    @Setter
    private String lastname;

    @Getter
    @Setter
    private String user_role;

    public UserDTO(UUID id, String user_email, String user_password, String firstname, String lastname, String user_role) {
        this.id = id;
        this.user_email = user_email;
        this.user_password = user_password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.user_role = user_role;
    }
}
