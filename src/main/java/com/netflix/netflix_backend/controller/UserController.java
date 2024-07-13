package com.netflix.netflix_backend.controller;
import com.netflix.netflix_backend.exception.NotFoundException;
import com.netflix.netflix_backend.model.User;
import com.netflix.netflix_backend.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    //Get All User Data
    @GetMapping("/searchAll")
    List<User> getAllUser(){
        return userRepository.findAll();
    }

    //Add new User to the system
    @PostMapping("/add")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    //Search User by id
    @GetMapping("/searchById/{id}")
    User getUserById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(()->new NotFoundException(id));
    }

    //search by category
    @GetMapping("/searchByEmail/{userEmail}")
    User getUserByCategory(@PathVariable String userEmail) {
        return userRepository.findByUserEmail(userEmail);
    }

    //Update User data
    @PutMapping("/update/{id}")
    User updateUser(@RequestBody User updateUser, @PathVariable Long id){
        return userRepository.findById(id).map(user -> {
            user.setUserEmail(updateUser.getUserEmail());
            user.setUserName(updateUser.getUserName());
            user.setPassword(updateUser.getPassword());
            return userRepository.save(user);
        }).orElseThrow(()->new NotFoundException(id));
    }

    //delete User
    @DeleteMapping("/delete/{id}")
    String deleteUser(@PathVariable Long id) {
        if (!userRepository.existsById(id)) {
            throw new NotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with id " + id + " has been deleted successfully.";
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        if (userRepository.findByUserEmail(user.getUserEmail()) != null) {
            return "User already registered as a user";
        }
        userRepository.save(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user, HttpSession session) {
        User existingUser = userRepository.findByUserEmail(user.getUserEmail());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            session.setAttribute("user", user);
            return "Login successful";
        } else {
            return "Invalid username or password";
        }
    }
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "Logged out successfully";
    }
}
