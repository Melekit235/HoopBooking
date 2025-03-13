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

    // Метод для получения всех судов (кортов)
    public List<Court> getAllCourts() {
        return courtRepository.findAll();
    }

    // Метод для получения корта по ID
    public Optional<Court> getCourtById(Integer courtId) {
        return courtRepository.findById(courtId);
    }

    // Метод для добавления нового корта
    public Court addCourt(Court court) {
        return courtRepository.save(court);
    }

    // Метод для обновления информации о корте
    public Court updateCourt(Integer courtId, Court courtDetails) {
        // Проверяем, существует ли корт с таким ID
        if (courtRepository.existsById(courtId)) {
            courtDetails.setCourtId(courtId);  // Устанавливаем ID для обновления
            return courtRepository.save(courtDetails);
        }
        return null;  // Или выбросить исключение, если корт не найден
    }

    // Метод для удаления корта по ID
    public void deleteCourt(Integer courtId) {
        courtRepository.deleteById(courtId);
    }

}
