package com.example.springboot.service;

import com.example.springboot.dto.ArrivalRequestDto;
import com.example.springboot.dto.ArrivalResponseDto;
import com.example.springboot.model.Arrival;
import com.example.springboot.repository.ArrivalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArrivalService {

    private final ArrivalRepository arrivalRepository;
    private final CourtService courtService;
    private final PlayerService playerService;

    @Autowired
    public ArrivalService(ArrivalRepository arrivalRepository, CourtService courtService, PlayerService playerService) {
        this.arrivalRepository = arrivalRepository;
        this.courtService = courtService;
        this.playerService = playerService;
    }

    public List<ArrivalResponseDto> getPlayerArrivalsByCourtId(Integer courtId) {
        return arrivalRepository.findPlayerArrivalsByCourtId(courtId);
    }

    public void addPlayerArrival(Integer courtId, ArrivalRequestDto arrivalRequestDto) {
        Arrival arrival = new Arrival();

        arrival.setPlayer(playerService.getPlayerById(arrivalRequestDto.getUserId()).get());
        arrival.setCourt(courtService.getCourtById(courtId).get());
        arrival.setArrivalDate(arrivalRequestDto.getDate());
        arrival.setStartTime(arrivalRequestDto.getStartTime());
        arrival.setEndTime(arrivalRequestDto.getEndTime());

        arrivalRepository.save(arrival);
    }
}
