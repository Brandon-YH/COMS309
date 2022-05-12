package com.example.SpringBoot_intro.player;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Player {
    private UUID id;
    private String playerName;
    private int level;
    private String email;



    public Player(@JsonProperty("id") UUID id, @JsonProperty("name")String playerName,@JsonProperty("level") int level, @JsonProperty("email")String email) {
        this.id = id;
        this.playerName = playerName;
        this.level = level;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
