package org.example.model.entity;

public class CourtType {

    private int typeId;
    private String type;

    public CourtType(int typeId, String type){
        this.typeId = typeId;
        this.type = type;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Тип корта{id=" + typeId + ", тип='" + type + "'}";
    }

}
