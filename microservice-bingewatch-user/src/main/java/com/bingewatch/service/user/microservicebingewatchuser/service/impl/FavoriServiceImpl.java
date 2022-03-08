package com.bingewatch.service.user.microservicebingewatchuser.service.impl;

import com.bingewatch.service.user.microservicebingewatchuser.dao.FavoriRepository;
import com.bingewatch.service.user.microservicebingewatchuser.dto.FavoriDTO;
import com.bingewatch.service.user.microservicebingewatchuser.entity.Favori;
import com.bingewatch.service.user.microservicebingewatchuser.service.FavoriService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoriServiceImpl implements FavoriService {

    @Autowired
    private FavoriRepository favoriRepository;

    @Override
    public List<FavoriDTO> getAllFavoris() {
        //liste favori de la base
        List<Favori> favoris = favoriRepository.findAll();
        // transfert vers une liste de favori dto
        List<FavoriDTO> favorisDTO = new ArrayList<>();

        for (Favori favori : favoris) {
            FavoriDTO favoriDTO = new FavoriDTO();
            BeanUtils.copyProperties(favori, favoriDTO);
            favorisDTO.add(favoriDTO);
        }
        return favorisDTO;
    }

    @Override
    public FavoriDTO getFavori(Integer id) {
        Favori favori = favoriRepository.findById(id).get();
        FavoriDTO favoriDTO = new FavoriDTO();
        BeanUtils.copyProperties(favori, favoriDTO);
        return favoriDTO;
    }

    @Override
    public void deleteFavori(Integer id) {}

    @Override
    public FavoriDTO createFavori(FavoriDTO favoriDTO) {
        Favori favori = new Favori();
        BeanUtils.copyProperties(favoriDTO, favori);
        Favori newFavori = favoriRepository.save(favori);
        BeanUtils.copyProperties(newFavori, favoriDTO);

        System.out.println(favori);
        return favoriDTO;
    }

    @Override
    public FavoriDTO updateFavori(Integer id, FavoriDTO favoriDTO) {return null;}
}
