package com.hanturgaev.fitzal.repositories;

import com.hanturgaev.fitzal.models.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {

}
