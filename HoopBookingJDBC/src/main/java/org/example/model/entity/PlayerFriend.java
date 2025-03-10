package org.example.model.entity;

import java.time.LocalDate;

public class PlayerFriend {

    private int playerId;
    private int friendId;
    private LocalDate friendshipDate;

    public PlayerFriend(int playerId, int friendId, LocalDate friendshipDate){
        this.playerId = playerId;
        this.friendId = friendId;
        this.friendshipDate = friendshipDate;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public LocalDate getFriendshipDate() {
        return friendshipDate;
    }

    public void setFriendshipDate(LocalDate friendshipDate) {
        this.friendshipDate = friendshipDate;
    }

    @Override
    public String toString() {
        return "Друг{id=" + playerId + ", id_друга=" + friendId + ", дата_дружбы=" + friendshipDate + "}";
    }

}
