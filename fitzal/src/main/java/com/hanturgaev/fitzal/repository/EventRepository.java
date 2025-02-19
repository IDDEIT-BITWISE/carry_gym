package com.hanturgaev.fitzal.repository;

import com.hanturgaev.fitzal.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // Найти события по тренеру
    List<Event> findByTrainerId(Long trainerId);

    // Найти события по участнику
    List<Event> findByParticipantsId(Long participantId);
}