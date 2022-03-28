package com.bingewatch.service.user.microservicebingewatchuser.repository;

import com.bingewatch.service.user.microservicebingewatchuser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User>findByPseudo(String pseudo);


}
