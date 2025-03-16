package com.example.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "court_types")
public class CourtType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "type", nullable = false)
    private String type;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
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
        return "CourtType{" +
                "typeId=" + typeId +
                ", type='" + type + '\'' +
                '}';
    }
}