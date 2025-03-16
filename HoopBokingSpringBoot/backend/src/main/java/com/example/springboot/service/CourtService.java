package com.example.springboot.service;

import com.example.springboot.dto.CourtDto;
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

    public List<CourtDto> getAllCourts() {
        return courtRepository.findAllCourtsWithNames();
    }

    public CourtDto getCourtDetailsById(Integer courtId) {
        return courtRepository.findCourtById(courtId);
    }

    public Optional<Court> getCourtById(Integer courtId) {
        return courtRepository.findById(courtId);
    }

}
