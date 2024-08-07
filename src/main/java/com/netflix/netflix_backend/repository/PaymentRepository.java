package com.netflix.netflix_backend.repository;
import com.netflix.netflix_backend.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByPackageId(Long packageId);
    List<Payment> findByUserEmail(String userEmail);
}
