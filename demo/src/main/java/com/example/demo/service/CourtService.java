package com.example.demo.service;

import com.example.demo.dto.CourtDto;
import com.example.demo.dto.CourtRequestDto;
import com.example.demo.model.City;
import com.example.demo.model.Court;
import com.example.demo.model.CourtType;
import com.example.demo.model.Player;
import com.example.demo.repository.CourtRepository;
import com.example.demo.repository.CourtTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourtService {

    private final CourtRepository courtRepository;
    private final CourtTypeService courtTypeService;
    private final CityService cityService;


    public CourtService(CourtRepository courtRepository, CourtTypeService courtTypeService, CityService cityService) {
        this.courtRepository = courtRepository;
        this.courtTypeService = courtTypeService;
        this.cityService = cityService;
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

    public void addCourt(CourtRequestDto request) {
        Court court = new Court();

        City city = cityService.getCityByName(request.getCityName())
                .orElseThrow(() -> new RuntimeException("City not found"));
        CourtType courtType = courtTypeService.getCourtTypeById(request.getCourtTypeId())
                .orElseThrow(() -> new RuntimeException("Court type not found"));

        court.setCourtAddress(request.getCourtAddress());
        court.setCity(city);
        court.setCourtType(courtType);

        courtRepository.save(court);
    }

    public void updateCourt(Integer courtId, CourtRequestDto request) {
        Optional<Court> existingCourt = courtRepository.findById(courtId);
        if (existingCourt.isPresent()) {
            Court court = existingCourt.get();
            City city = cityService.getCityByName(request.getCityName())
                    .orElseThrow(() -> new RuntimeException("City not found"));
            CourtType courtType = courtTypeService.getCourtTypeById(request.getCourtTypeId())
                    .orElseThrow(() -> new RuntimeException("Court type not found"));

            court.setCity(city);
            court.setCourtType(courtType);
            court.setCourtAddress(request.getCourtAddress());

            courtRepository.save(court);
        }
    }

    public boolean deleteCourt(Integer courtId) {
        Optional<Court> existingCourt = courtRepository.findById(courtId);
        if (existingCourt.isPresent()) {
            courtRepository.delete(existingCourt.get());
            return true;
        }
        return false;
    }
}
