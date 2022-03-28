package com.bingewatch.service.user.microservicebingewatchuser.repository;

import com.bingewatch.service.user.microservicebingewatchuser.entity.Favori;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface FavoriRepository extends JpaRepository<Favori, Integer> {
    List<Favori> findByUserId(Integer id);
    @Transactional
    void deleteByUserId(Integer userId);
}
