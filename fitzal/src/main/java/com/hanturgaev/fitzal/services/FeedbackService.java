package com.hanturgaev.fitzal.services;

import com.hanturgaev.fitzal.models.Event;
import com.hanturgaev.fitzal.models.Feedback;
import com.hanturgaev.fitzal.models.User;
import com.hanturgaev.fitzal.repositories.EventRepository;
import com.hanturgaev.fitzal.repositories.FeedbackRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;
    private final EventRepository eventRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository, EventRepository eventRepository) {
        this.feedbackRepository = feedbackRepository;
        this.eventRepository = eventRepository;
    }

    @Transactional
    public void leaveFeedback(Long eventId, Long feedbackId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Ивент не найден"));
        Feedback feedback = feedbackRepository.findById(feedbackId)
                .orElseThrow(() -> new RuntimeException("Отзыв не найден"));

        User user = feedback.getClient();
        if (feedbackRepository.findByClientId(user.getId()).contains(feedback)) {
            throw new RuntimeException("Пользователь уже оставил отзыв под этим событием");
        }




    }


}
