package com.hanturgaev.fitzal.services;

import com.hanturgaev.fitzal.models.Trainer;
import com.hanturgaev.fitzal.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    @Autowired
    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public void createTrainer(Trainer trainer) {
        trainerRepository.save(trainer);
    }




}
