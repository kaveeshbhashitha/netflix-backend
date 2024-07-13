package com.netflix.netflix_backend.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String userEmail;
    private String password;
    @Column(name = "userRole")
    private String userRole = "User";
    @Column(name = "dateViewed")
    private LocalDate dateViewed = LocalDate.now();
    @Column(name = "timeViewed")
    private LocalTime timeViewed = LocalTime.now();

    public Long getUserId() {
        return userId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
