package com.hanturgaev.fitzal.services;

import com.hanturgaev.fitzal.models.Trainer;
import com.hanturgaev.fitzal.repositories.TrainerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    @Autowired
    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Transactional
    public void createTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
    }

    @Transactional
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }






}
