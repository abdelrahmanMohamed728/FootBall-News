package com.example.abdo.footballnews.Classes;

public class Team {
    private String id;
    private String num;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team(String id, String num, String name) {
        this.id = id;
        this.num = num;
        this.name = name;
    }
}
