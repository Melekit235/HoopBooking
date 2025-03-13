package com.example.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "courts")
public class Court {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоматическая генерация идентификатора
    @Column(name = "court_id")
    private Integer courtId;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;  // Связь с таблицей cities

    @ManyToOne
    @JoinColumn(name = "court_type", nullable = false)
    private CourtType courtType;  // Связь с таблицей court_types

    @Column(name = "court_address", nullable = false)
    private String courtAddress;  // Адрес площадки

    // Getters and Setters
    public Integer getCourtId() {
        return courtId;
    }

    public void setCourtId(Integer courtId) {
        this.courtId = courtId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public CourtType getCourtType() {
        return courtType;
    }

    public void setCourtType(CourtType courtType) {
        this.courtType = courtType;
    }

    public String getCourtAddress() {
        return courtAddress;
    }

    public void setCourtAddress(String courtAddress) {
        this.courtAddress = courtAddress;
    }
}
