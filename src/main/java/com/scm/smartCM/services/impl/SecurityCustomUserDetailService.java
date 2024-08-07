package com.scm.smartCM.services.impl;

import com.scm.smartCM.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SecurityCustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      //load user
        return userRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found with this email id"));
    }
}
