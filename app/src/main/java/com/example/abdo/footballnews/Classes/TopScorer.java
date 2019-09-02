package com.example.abdo.footballnews.Classes;

public class TopScorer {
    private String id;
    private String rank;
    private String name;
    private String goals;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public TopScorer(String id, String rank, String name, String goals) {
        this.id = id;
        this.rank = rank;
        this.name = name;
        this.goals = goals;
    }
}
