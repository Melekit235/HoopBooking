package org.example.model.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

public class PlayerArrival {

    private int playerId;
    private int courtId;
    private LocalDate arrivalDate;
    private LocalTime startTime;
    private LocalTime endTime;

    public PlayerArrival(int playerId, int courtId, LocalDate arrivalDate, LocalTime startTime, LocalTime endTime){
        this.playerId = playerId;
        this.courtId = courtId;
        this.arrivalDate = arrivalDate;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Приход игрока{playerId=" + playerId + ", courtId=" + courtId +
                ", дата_прихода=" + arrivalDate + ", время_старта=" + startTime +
                ", время_окончания=" + endTime + "}";
    }

}
