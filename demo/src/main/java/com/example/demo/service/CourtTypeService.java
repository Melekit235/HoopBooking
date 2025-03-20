package com.example.demo.service;

import com.example.demo.model.CourtType;
import com.example.demo.repository.CourtTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourtTypeService {

    private final CourtTypeRepository courtTypeRepository;

    @Autowired
    public CourtTypeService(CourtTypeRepository courtTypeRepository) {
        this.courtTypeRepository = courtTypeRepository;
    }


    public Optional<CourtType> getCourtTypeById(Integer typeId) {
        return courtTypeRepository.findById(typeId);
    }

}
