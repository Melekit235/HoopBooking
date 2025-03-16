package com.example.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "favorites")
@IdClass(FavoriteId.class)
public class Favorite {

    @Id
    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "player_id", nullable = false)
    private Player player;

    @Id
    @ManyToOne
    @JoinColumn(name = "court_id", referencedColumnName = "court_id", nullable = false)
    private Court court;

    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }

    public Court getCourt() { return court; }
    public void setCourt(Court court) { this.court = court; }

    @Override
    public String toString() {
        return "Favorite{" +
                "player=" + player +
                ", court=" + court +
                '}';
    }
}
