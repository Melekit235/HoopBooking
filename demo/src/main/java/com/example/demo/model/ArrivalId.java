package com.example.demo.model;

import java.io.Serializable;
import java.util.Objects;

public class ArrivalId implements Serializable {
    private Integer player;
    private Integer court;

    public ArrivalId() {}

    public ArrivalId(Integer player, Integer court) {
        this.player = player;
        this.court = court;
    }

    public Integer getPlayer() { return player; }
    public void setPlayer(Integer player) { this.player = player; }

    public Integer getCourt() { return court; }
    public void setCourt(Integer court) { this.court = court; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrivalId that = (ArrivalId) o;
        return Objects.equals(player, that.player) && Objects.equals(court, that.court);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, court);
    }
}
