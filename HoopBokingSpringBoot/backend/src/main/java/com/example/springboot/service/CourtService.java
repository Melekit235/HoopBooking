package com.example.springboot.service;

import com.example.springboot.model.Court;
import com.example.springboot.repository.CourtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourtService {

    private final CourtRepository courtRepository;

    @Autowired
    public CourtService(CourtRepository courtRepository) {
        this.courtRepository = courtRepository;
    }

    public List<Court> getAllCourts() {
        return courtRepository.findAll();
    }

    public Optional<Court> getCourtById(Integer courtId) {
        return courtRepository.findById(courtId);
    }

    public Court addCourt(Court court) {
        return courtRepository.save(court);
    }

    public Court updateCourt(Integer courtId, Court courtDetails) {
        // Проверяем, существует ли корт с таким ID
        if (courtRepository.existsById(courtId)) {
            courtDetails.setCourtId(courtId);
            return courtRepository.save(courtDetails);
        }
        return null;
    }

    public void deleteCourt(Integer courtId) {
        courtRepository.deleteById(courtId);
    }

}
