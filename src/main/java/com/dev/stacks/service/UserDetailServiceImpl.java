//package com.dev.stacks.service;
//
//import com.dev.stacks.model.User;
//import com.dev.stacks.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//public class UserDetailServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername();
//        if(user != null) {
//            return org.springframework.security.core.userdetails.User.builder()
//                    .username(user.getUsername())
//                    .password(user.getPassword())
//                    .roles(user.getRoles()).toArray(new String[0])
//                    .build();
//            throw new UsernameNotFoundException("user not found with username: "+ username);
//        }
//
//    }
//}
