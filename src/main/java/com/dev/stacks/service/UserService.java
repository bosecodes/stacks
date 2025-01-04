package com.dev.stacks.service;

import com.dev.stacks.model.User;
import com.dev.stacks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCrypt for password encoding
    }

    public User createUser (User user) {
        return userRepository.save(user);
    }

    public User registerUser(User user) {
        // hash the user's password before saving
        String hashedPassword = passwordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);

        // save the user to the db
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        // Logic to retrieve all users (e.g., from a database)
        return userRepository.findAll();
    }

}
