package com.scm.smartCM.services.impl;

import com.scm.smartCM.entities.User;
import com.scm.smartCM.helpers.AppConstants;
import com.scm.smartCM.helpers.ResourcesNotFoundException;
import com.scm.smartCM.repositories.UserRepo;
import com.scm.smartCM.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImp.class);

    @Override
    public User saveUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoleList(List.of(AppConstants.ROLE_USER));
        logger.info(user.getProvider().toString());
        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> UpdateUser(User user) {
        User user2 = userRepo.findById(user.getUserId())
                .orElseThrow(() -> new ResourceAccessException("User not found"));
        // Update fields
        user2.setUserId(user.getUserId());
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        user2.setProfilePic(user.getProfilePic());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setEnabled(user.isEnabled());
        user2.setEmailVerified(user.isEmailVerified());
        user2.setPhoneVerified(user.isPhoneVerified());
        user2.setProvider(user.getProvider());
        user2.setProviderUserId(user.getProviderUserId());

        // Save in db
        User save = userRepo.save(user2);
        return Optional.ofNullable(save);
    }

    @Override
    public void deleteUser(String id) {
        User user2 = userRepo.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("User not found"));
        userRepo.delete(user2);
    }

    @Override
    public boolean isUserExist(String userId) {
        return userRepo.existsById(userId);
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        return userRepo.findByEmail(email).isPresent();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
