package com.hanturgaev.fitzal.repositories;

import com.hanturgaev.fitzal.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    // Найти отзывы по клиенту
    List<Feedback> findByClientId(Long clientId);

    // Найти отзывы по событию
    List<Feedback> findByEventId(Long eventId);
}