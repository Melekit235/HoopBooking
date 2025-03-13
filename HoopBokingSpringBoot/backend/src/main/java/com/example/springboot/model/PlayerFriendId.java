package com.example.springboot.model;

import java.io.Serializable;
import java.util.Objects;

public class PlayerFriendId implements Serializable {
    private Long player;
    private Long friend;

    public PlayerFriendId() {}

    public PlayerFriendId(Long player, Long friend) {
        this.player = player;
        this.friend = friend;
    }

    public Long getPlayer() { return player; }
    public void setPlayer(Long player) { this.player = player; }

    public Long getFriend() { return friend; }
    public void setFriend(Long friend) { this.friend = friend; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerFriendId that = (PlayerFriendId) o;
        return Objects.equals(player, that.player) && Objects.equals(friend, that.friend);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, friend);
    }
}
