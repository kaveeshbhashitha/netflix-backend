package com.netflix.netflix_backend.repository;
import com.netflix.netflix_backend.model.Video;
import com.netflix.netflix_backend.model.View;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ViewRepository extends JpaRepository<View, Long> {
    List<View> findByVideoId(Long videoId);
    List<View> findByUserId(Long userId);
}
