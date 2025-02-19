package com.hanturgaev.fitzal.services;

import com.hanturgaev.fitzal.models.News;
import com.hanturgaev.fitzal.repositories.NewsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Transactional
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }


}
