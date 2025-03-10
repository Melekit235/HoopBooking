package org.example.model.entity;

public class Favorite {

    private int playerId;
    private int courtId;

    public Favorite(int playerId, int courtId){
        this.playerId = playerId;
        this.courtId  = courtId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getCourtId() {
        return courtId;
    }

    public void setCourtId(int courtId) {
        this.courtId = courtId;
    }

    @Override
    public String toString() {
        return "Избранное{playerId=" + playerId + ", courtId=" + courtId + "}";
    }

}
