package com.netflix.netflix_backend.repository;
import com.netflix.netflix_backend.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {
    Video findByVideoTitle(String videoTitle);
    List<Video> findByCategory(String category);
    Video findByVideoType(String videoType);
}
