package com.dev.stacks.service;

import com.dev.stacks.config.CustomUserDetails;
import com.dev.stacks.model.User;
import com.dev.stacks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // in real, you would load user from db
    private final List<CustomUserDetails> users = List.of(
            new CustomUserDetails("user1", "{noop}password", List.of(() -> "ROLE_USER")),
            new CustomUserDetails("admin", "{noop}password", List.of(() -> "ROLE_ADMIN"))
    );

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return users.stream()
//                .filter(user -> user.getUsername().equals(username))
//                .findFirst()
//                .orElseThrow(() -> new UsernameNotFoundException(("User not found: " + username)));
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        // Convert roles to GrantedAuthority
        Collection<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());

        // Return CustomUserDetails
        return new CustomUserDetails(user.getUsername(), user.getPassword(), authorities);
    }
}
