package com.scm.smartCM.services;

import com.scm.smartCM.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> getUserById(String id);
    Optional<User> UpdateUser(User user);
    void deleteUser(String id);
    boolean isUserExist(String id);
    boolean isUserExistByEmail(String email);
    List<User> getAllUsers();

}
