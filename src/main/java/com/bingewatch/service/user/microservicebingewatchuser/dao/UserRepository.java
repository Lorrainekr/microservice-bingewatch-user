package com.bingewatch.service.user.microservicebingewatchuser.dao;

import com.bingewatch.service.user.microservicebingewatchuser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    Optional<User> findByEmail(String email);
    Boolean existsByEmail(String email);

}
