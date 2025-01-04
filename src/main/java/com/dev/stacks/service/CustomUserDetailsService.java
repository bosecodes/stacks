package com.dev.stacks.service;

import com.dev.stacks.config.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // in real, you would load user from db
    private final List<CustomUserDetails> users = List.of(
            new CustomUserDetails("user1", "{noop}password", List.of(() -> "ROLE_USER")),
            new CustomUserDetails("admin", "{noop}password", List.of(() -> "ROLE_ADMIN"))
    );

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException(("User not found: " + username)));
    }
}
