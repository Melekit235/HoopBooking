package org.example.model.dao;

import org.example.model.entity.CourtType;

import java.util.List;

public interface CourtTypeDao {

    void addCourtType(CourtType courtType);
    CourtType getCourtType(int typeId);
    List<CourtType> getAllCourtTypes();
    void updateCourtType(CourtType courtType);
    void deleteCourtType(int typeId);
}
