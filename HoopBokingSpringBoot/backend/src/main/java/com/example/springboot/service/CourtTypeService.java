package com.example.springboot.service;

import com.example.springboot.model.CourtType;
import com.example.springboot.repository.CourtTypeRepository;
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
