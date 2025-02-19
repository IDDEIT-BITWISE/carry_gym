package com.hanturgaev.fitzal.repositories;

import com.hanturgaev.fitzal.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByClientId(Long clientId);

    List<Feedback> findByEventId(Long eventId);


}