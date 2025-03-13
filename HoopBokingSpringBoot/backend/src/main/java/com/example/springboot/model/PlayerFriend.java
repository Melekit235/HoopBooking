package com.example.springboot.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "player_friends")
@IdClass(PlayerFriendId.class) // Указываем составной ключ
public class PlayerFriend {

    @Id
    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "player_id", nullable = false)
    private Player player;

    @Id
    @ManyToOne
    @JoinColumn(name = "friend_id", referencedColumnName = "player_id", nullable = false)
    private Player friend;

    @Column(name = "friendship_date", nullable = false)
    private LocalDate friendshipDate;

    // Getters and Setters
    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }

    public Player getFriend() { return friend; }
    public void setFriend(Player friend) { this.friend = friend; }

    public LocalDate getFriendshipDate() { return friendshipDate; }
    public void setFriendshipDate(LocalDate friendshipDate) { this.friendshipDate = friendshipDate; }

    @Override
    public String toString() {
        return "PlayerFriend{" +
                "player=" + player +
                ", friend=" + friend +
                ", friendshipDate=" + friendshipDate +
                '}';
    }
}
