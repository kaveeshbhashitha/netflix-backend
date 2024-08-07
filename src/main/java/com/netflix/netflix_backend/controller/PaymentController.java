package com.netflix.netflix_backend.controller;
import com.netflix.netflix_backend.exception.NotFoundException;
import com.netflix.netflix_backend.model.Payment;
import com.netflix.netflix_backend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    //Get All Video Data
    @GetMapping("/searchAll")
    List<Payment> getAllPayment(){
        return paymentRepository.findAll();
    }

    //Add new video to the system
    @PostMapping("/add")
    Payment newPayment(@RequestBody Payment newPayment){
        return paymentRepository.save(newPayment);
    }

    //Search video by id
    @GetMapping("/searchById/{id}")
    Payment getPaymentById(@PathVariable Long id){
        return paymentRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    @GetMapping("/searchPackageById/{id}")
    public List<Payment> getPaymentPackageById(@PathVariable Long id){
        return paymentRepository.findByPackageId(id);
    }

    //search by category
    @GetMapping("/searchUserEmail/{email}")
    public List<Payment> getVideosByCategory(@PathVariable String email) {
        return paymentRepository.findByUserEmail(email);
    }

    //delete video
    @DeleteMapping("/delete/{id}")
    String deletePayment(@PathVariable Long id) {
        if (!paymentRepository.existsById(id)) {
            throw new NotFoundException(id);
        }
        paymentRepository.deleteById(id);
        return "Payment with id " + id + " has been deleted successfully.";
    }
}
