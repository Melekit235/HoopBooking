package org.example.model.entity;

public class Court {

    private int courtId;
    private int cityId;
    private int courtTypeId;
    private String courtAddress;

    public Court(int courtId, int cityId, int courtTypeId, String courtAddress) {
        this.courtId = courtId;
        this.cityId = cityId;
        this.courtTypeId = courtTypeId;
        this.courtAddress = courtAddress;
    }

    public int getCourtId() {
        return courtId;
    }

    public void setCourtId(int courtId) {
        this.courtId = courtId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getCourtTypeId() {
        return courtTypeId;
    }

    public void setCourtTypeId(int courtTypeId) {
        this.courtTypeId = courtTypeId;
    }

    public String getCourtAddress() {
        return courtAddress;
    }

    public void setCourtAddress(String courtAddress) {
        this.courtAddress = courtAddress;
    }

    @Override
    public String toString() {
        return "Корт{id=" + courtId + ", cityId=" + cityId + ", courtTypeId=" + courtTypeId +
                ", адрес='" + courtAddress + "'}";
    }

}
