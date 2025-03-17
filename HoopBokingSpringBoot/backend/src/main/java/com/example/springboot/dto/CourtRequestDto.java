package com.example.springboot.dto;

import jakarta.persistence.criteria.CriteriaBuilder;

public class CourtRequestDto {

    private String cityName;
    private Integer courtTypeId;
    private String courtAddress;

    public CourtRequestDto(Integer courtTypeId, String cityName,  String courtAddress) {
        this.cityName = cityName;
        this.courtTypeId = courtTypeId;
        this.courtAddress = courtAddress;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCourtTypeId() {
        return courtTypeId;
    }

    public void setCourtTypeId(Integer courtTypeId) {
        this.courtTypeId = courtTypeId;
    }

    public String getCourtAddress() {
        return courtAddress;
    }

    public void setCourtAddress(String courtAddress) {
        this.courtAddress = courtAddress;
    }
}
