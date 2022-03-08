package com.bingewatch.service.user.microservicebingewatchuser.dao;

import com.bingewatch.service.user.microservicebingewatchuser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {}
