package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by ericweidman on 3/10/16.
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false, unique = true)
    String name;

    @Column(nullable = false)
    String passwordHash;


    public User() {
    }

    public User(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public User(String name, String passwordHash) {
        this.name = name;
        this.passwordHash = passwordHash;
    }
}
