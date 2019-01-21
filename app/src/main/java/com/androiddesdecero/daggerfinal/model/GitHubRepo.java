package com.androiddesdecero.daggerfinal.model;

/**
 * Created by albertopalomarrobledo on 5/1/19.
 */

public class GitHubRepo {
    private String name;

    private Owner owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}

