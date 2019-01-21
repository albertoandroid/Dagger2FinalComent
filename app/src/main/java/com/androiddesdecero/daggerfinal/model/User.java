package com.androiddesdecero.daggerfinal.model;

/**
 * Created by albertopalomarrobledo on 5/1/19.
 */

public class User {

    private String username;

    private String edad;

    public User(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEdad() {
        return edad;
    }
}
