package com.netflix.netflix_backend.model;
public class ViewDetails {
    private Long viewId;
    private String videoName;
    private String videoTitle;
    private String userName;
    private String userEmail;
    private String dateViewed;
    private String timeViewed;

    public ViewDetails(View view, Video video, User user) {
        if (video != null) {
            this.videoName = video.getYoutubeId();
            this.videoTitle = video.getVideoTitle();
        }
        if (user != null) {
            this.userName = user.getUserName();
            this.userEmail = user.getUserEmail();
        }
        this.dateViewed = String.valueOf(view.getDateViewed());
        this.timeViewed = String.valueOf(view.getTimeViewed());
        this.viewId = view.getViewId();
    }

    // Getters and setters
    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getDateViewed() {
        return dateViewed;
    }

    public void setDateViewed(String dateViewed) {
        this.dateViewed = dateViewed;
    }

    public String getTimeViewed() {
        return timeViewed;
    }

    public void setTimeViewed(String timeViewed) {
        this.timeViewed = timeViewed;
    }
    public Long getViewId() {
        return viewId;
    }

    public void setViewId(Long viewId) {
        this.viewId = viewId;
    }
}
