package org.example.model.dao;

import org.example.model.entity.Court;

import java.util.List;

public interface CourtDao {

    void addCourt(Court court);
    Court getCourt(int courtId);
    List<Court> getAllCourts();
    void updateCourt(Court court);
    void deleteCourt(int courtId);

}
