package com.example.springboot.service;

import com.example.springboot.model.CourtType;
import com.example.springboot.repository.CourtTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourtTypeService {

    private final CourtTypeRepository courtTypeRepository;

    @Autowired
    public CourtTypeService(CourtTypeRepository courtTypeRepository) {
        this.courtTypeRepository = courtTypeRepository;
    }

    public List<CourtType> getAllCourtTypes() {
        return courtTypeRepository.findAll();
    }

    public Optional<CourtType> getCourtTypeById(Integer typeId) {
        return courtTypeRepository.findById(typeId);
    }

    public CourtType addCourtType(CourtType courtType) {
        return courtTypeRepository.save(courtType);
    }

    public CourtType updateCourtType(Integer typeId, CourtType courtTypeDetails) {
        if (courtTypeRepository.existsById(typeId)) {
            courtTypeDetails.setTypeId(typeId);
            return courtTypeRepository.save(courtTypeDetails);
        }
        return null;
    }

    public void deleteCourtType(Integer typeId) {
        courtTypeRepository.deleteById(typeId);
    }
}
