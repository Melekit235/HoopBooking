package com.example.springboot.model;

import java.io.Serializable;
import java.util.Objects;

public class PlayerArrivalId implements Serializable {
    private Long player;
    private Long court;

    public PlayerArrivalId() {}

    public PlayerArrivalId(Long player, Long court) {
        this.player = player;
        this.court = court;
    }

    public Long getPlayer() { return player; }
    public void setPlayer(Long player) { this.player = player; }

    public Long getCourt() { return court; }
    public void setCourt(Long court) { this.court = court; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerArrivalId that = (PlayerArrivalId) o;
        return Objects.equals(player, that.player) && Objects.equals(court, that.court);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, court);
    }
}
