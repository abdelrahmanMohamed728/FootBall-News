package com.example.abdo.footballnews.Classes;

public class Standing {
    private String Id;
    private String rank;
    private String name;
    private String points;

    public Standing(String id, String rank, String name, String points) {
        Id = id;
        this.rank = rank;
        this.name = name;
        this.points = points;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
}
