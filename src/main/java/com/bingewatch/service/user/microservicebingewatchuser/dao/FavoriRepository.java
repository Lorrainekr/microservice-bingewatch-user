package com.bingewatch.service.user.microservicebingewatchuser.dao;

import com.bingewatch.service.user.microservicebingewatchuser.dto.FavoriDTO;
import com.bingewatch.service.user.microservicebingewatchuser.entity.Favori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
public interface FavoriRepository extends JpaRepository <Favori, Integer>{}
