package com.example.springboot.dto;

public class CourtDto {
    private Integer courtId;
    private String cityName;
    private String courtTypeName;
    private String courtAddress;

    public CourtDto(Integer courtId, String cityName, String courtTypeName, String courtAddress) {
        this.courtId = courtId;
        this.cityName = cityName;
        this.courtTypeName = courtTypeName;
        this.courtAddress = courtAddress;
    }

    public Integer getCourtId() {
        return courtId;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCourtTypeName() {
        return courtTypeName;
    }

    public String getCourtAddress() {
        return courtAddress;
    }
}
