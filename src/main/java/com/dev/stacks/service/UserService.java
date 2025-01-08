package com.dev.stacks.service;

import com.dev.stacks.model.Role;
import com.dev.stacks.model.User;
import com.dev.stacks.repository.RoleRepository;
import com.dev.stacks.repository.UserRepository;
import jakarta.annotation.PostConstruct;
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

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        // Create the roles
        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setName("USER");
        roleRepository.save(userRole);

        // Create Users
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        userRepository.save(admin);

        User user = new User();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("user"));
        userRepository.save(user);
    }

    public User createUser (User user) {
        return userRepository.save(user);
    }

    public User registerUser(User user) {
        // hash the user's password before saving
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        // save the user to the db
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        // Logic to retrieve all users (e.g., from a database)
        return userRepository.findAll();
    }

}
