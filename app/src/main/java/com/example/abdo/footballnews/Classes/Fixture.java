package com.example.abdo.footballnews.Classes;

public class Fixture {
    private String id;
    private String home;
    private String away;
    private String score;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Fixture(String id, String home, String away, String score) {
        this.id = id;
        this.home = home;
        this.away = away;
        this.score = score;
    }
}
