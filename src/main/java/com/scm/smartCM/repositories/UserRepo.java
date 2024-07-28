package com.scm.smartCM.repositories;

import com.scm.smartCM.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    //extra methods db relatesoperations
    //custom query methods
    // custom

    Optional<User> findByEmail(String email);
}
