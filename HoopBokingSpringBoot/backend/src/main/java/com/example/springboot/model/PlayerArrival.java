package com.example.springboot.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "player_arrivals")
@IdClass(PlayerArrivalId.class)
public class PlayerArrival {

    @Id
    @ManyToOne
    @JoinColumn(name = "player_id", referencedColumnName = "player_id", nullable = false)
    private Player player;

    @Id
    @ManyToOne
    @JoinColumn(name = "court_id", referencedColumnName = "court_id", nullable = false)
    private Court court;

    @Column(name = "arrival_date", nullable = false)
    private LocalDate arrivalDate;

    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    // Getters and Setters
    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }

    public Court getCourt() { return court; }
    public void setCourt(Court court) { this.court = court; }

    public LocalDate getArrivalDate() { return arrivalDate; }
    public void setArrivalDate(LocalDate arrivalDate) { this.arrivalDate = arrivalDate; }

    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }

    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }

    @Override
    public String toString() {
        return "PlayerArrival{" +
                "player=" + player +
                ", court=" + court +
                ", arrivalDate=" + arrivalDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
