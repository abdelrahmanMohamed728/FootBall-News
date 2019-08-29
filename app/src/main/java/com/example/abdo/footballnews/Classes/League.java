package com.example.abdo.footballnews.Classes;

public class League {
    private String id;
    private String name;
    private String Country;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public League(String id, String name, String country) {
        this.id = id;
        this.name = name;
        Country = country;
    }
}
