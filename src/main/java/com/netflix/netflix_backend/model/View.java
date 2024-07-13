package com.netflix.netflix_backend.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class View {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long viewId;
    private Long videoId;
    private Long userId;
    @Column(name = "dateViewed")
    private LocalDate dateViewed = LocalDate.now();
    @Column(name = "timeViewed")
    private LocalTime timeViewed = LocalTime.now();

    public Long getViewId() {
        return viewId;
    }

    public void setViewId(Long viewId) {
        this.viewId = viewId;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getDateViewed() {
        return dateViewed;
    }

    public void setDateViewed(LocalDate dateViewed) {
        this.dateViewed = dateViewed;
    }

    public LocalTime getTimeViewed() {
        return timeViewed;
    }

    public void setTimeViewed(LocalTime timeViewed) {
        this.timeViewed = timeViewed;
    }
}
