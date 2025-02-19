package com.hanturgaev.fitzal.repository;

import com.hanturgaev.fitzal.model.Feedback;
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