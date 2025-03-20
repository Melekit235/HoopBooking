package com.example.demo.dto;

public class FavoriteDto {

    private Integer courtId;
    private String courtAddress;
    private String cityName;
    private String courtType;

    public FavoriteDto(Integer courtId, String courtType, String courtAddress, String cityName) {
        this.courtId = courtId;
        this.courtAddress = courtAddress;
        this.cityName = cityName;
        this.courtType = courtType;
    }

    public Integer getCourtId() {
        return courtId;
    }


    public String getCourtAddress() {
        return courtAddress;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCourtType() {
        return courtType;
    }
}
