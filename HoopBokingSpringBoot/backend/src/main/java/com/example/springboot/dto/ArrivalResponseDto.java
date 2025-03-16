package com.example.springboot.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class ArrivalResponseDto {

    private String playerName;
    private LocalDate arrivalDate;
    private LocalTime startTime;
    private LocalTime endTime;

    public ArrivalResponseDto(String playerName, LocalDate arrivalDate, LocalTime startTime, LocalTime endTime) {
        this.playerName = playerName;
        this.arrivalDate = arrivalDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
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
}
