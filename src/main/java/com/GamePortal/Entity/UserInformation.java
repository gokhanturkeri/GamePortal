package com.GamePortal.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "userinformation")
public class UserInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column
    private String userName;
    @Column
    private int userCredit;

    @ManyToMany(mappedBy = "usersGame", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<GameInformation> games = new HashSet<>();

    public UserInformation(){}

    public UserInformation(int userId, String userName, int userCredit) {
        this.userId = (long) userId;
        this.userName = userName;
        this.userCredit = userCredit;
    }

    public void addGame(GameInformation gameInformation){

        games.add(gameInformation);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserCredit() {
        return userCredit;
    }

    public void setUserCredit(int userCredit) {
        this.userCredit = userCredit;
    }
    public Set<GameInformation> getGames() {
        return games;
    }
}
