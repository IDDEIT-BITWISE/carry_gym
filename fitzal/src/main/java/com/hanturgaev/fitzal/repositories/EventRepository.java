package com.hanturgaev.fitzal.repositories;

import com.hanturgaev.fitzal.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByTrainerId(Long trainerId);

    List<Event> findByParticipantsId(Long participantId);
}