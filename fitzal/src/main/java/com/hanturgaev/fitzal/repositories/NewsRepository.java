package com.hanturgaev.fitzal.repositories;

import com.hanturgaev.fitzal.models.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

}
