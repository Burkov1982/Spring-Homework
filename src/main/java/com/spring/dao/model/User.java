package com.spring.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "user")
public class User {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
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
    private Role user_role;

    public User(UUID id, String user_email, String user_password, String firstname, String lastname, String user_role) {
        this.id = id;
        this.user_email = user_email;
        this.user_password = user_password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.user_role = Role.valueOf(user_role);
    }

    public User() {
    }
}
