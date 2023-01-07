package com.GamePortal.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "gameinformation")
public class GameInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;
    @Column
    private String gameName;
    @Column
    private int gameCost;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(
            name = "user_game",
            joinColumns = {@JoinColumn(name = "game_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )

    @JsonManagedReference
    private Set<UserInformation> usersGame = new HashSet<>();

    public GameInformation() {
    }

    public GameInformation(int gameId, String gameName, int gameCost) {
        super();
        this.gameId = (long) gameId;
        this.gameName = gameName;
        this.gameCost = gameCost;
    }

    public void addUser(UserInformation userInformation) {
        usersGame.add(userInformation);
    }


    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getGameCost() {
        return gameCost;
    }

    public void setGameCost(int gameCost) {
        this.gameCost = gameCost;
    }

    public Set<UserInformation> getUsers() {
        return usersGame;
    }

    public void usersGame(UserInformation user) {
        usersGame.add(user);
    }
    public Set<UserInformation> getUsersGame() {
        return usersGame;
    }
}
