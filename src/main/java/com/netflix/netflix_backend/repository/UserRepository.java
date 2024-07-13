package com.netflix.netflix_backend.repository;
import com.netflix.netflix_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserEmail(String username);
}
