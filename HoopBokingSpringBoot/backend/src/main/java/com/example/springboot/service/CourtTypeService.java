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

    // Метод для получения всех типов кортов
    public List<CourtType> getAllCourtTypes() {
        return courtTypeRepository.findAll();
    }

    // Метод для получения типа корта по ID
    public Optional<CourtType> getCourtTypeById(Integer typeId) {
        return courtTypeRepository.findById(typeId);
    }

    // Метод для добавления нового типа корта
    public CourtType addCourtType(CourtType courtType) {
        return courtTypeRepository.save(courtType);
    }

    // Метод для обновления типа корта
    public CourtType updateCourtType(Integer typeId, CourtType courtTypeDetails) {
        if (courtTypeRepository.existsById(typeId)) {
            courtTypeDetails.setTypeId(typeId); // Устанавливаем ID для обновления
            return courtTypeRepository.save(courtTypeDetails);
        }
        return null; // Или выбросить исключение, если тип корта не найден
    }

    // Метод для удаления типа корта по ID
    public void deleteCourtType(Integer typeId) {
        courtTypeRepository.deleteById(typeId);
    }
}
