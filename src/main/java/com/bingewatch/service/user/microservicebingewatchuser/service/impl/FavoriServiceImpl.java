package com.bingewatch.service.user.microservicebingewatchuser.service.impl;

import com.bingewatch.service.user.microservicebingewatchuser.dao.FavoriaddRepository;
import com.bingewatch.service.user.microservicebingewatchuser.model.Favorisadd;
import com.bingewatch.service.user.microservicebingewatchuser.model.dto.FavoriDTO;
import com.bingewatch.service.user.microservicebingewatchuser.model.dto.Request;
import com.bingewatch.service.user.microservicebingewatchuser.model.exception.FavoriFoundException;
import com.bingewatch.service.user.microservicebingewatchuser.service.FavoriService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class FavoriServiceImpl implements FavoriService {

    @Autowired
    private FavoriaddRepository favoriRepository;

    @Override
    public List<FavoriDTO> getAllFavoris() {
        //liste favori de la base
        List<Favorisadd> favoris = favoriRepository.findAll();
        // transfert vers une liste de favori dto
        List<FavoriDTO> favorisDTO = new ArrayList<>();

        for (Favorisadd favori : favoris) {
            FavoriDTO favoriDTO = new FavoriDTO();
            BeanUtils.copyProperties(favori, favoriDTO);
            favorisDTO.add(favoriDTO);
        }
        return favorisDTO;
    }

    public Boolean Favorinotexist(@Valid Request request) throws FavoriFoundException {

        if(favoriRepository.existsByTitle(request.getEmail())) {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public FavoriDTO getFavori(Integer id) {
        Favorisadd favori = favoriRepository.findById(id).get();
        FavoriDTO favoriDTO = new FavoriDTO();
        BeanUtils.copyProperties(favori, favoriDTO);
        return favoriDTO;
    }

    @Override
    public void deleteFavori(Integer id) {}

    @Override
    public FavoriDTO createFavori(FavoriDTO favoriDTO) {
        Favorisadd favori = new Favorisadd();
        BeanUtils.copyProperties(favoriDTO, favori);
        Favorisadd newFavori = favoriRepository.save(favori);
        BeanUtils.copyProperties(newFavori, favoriDTO);

        System.out.println(favori);
        return favoriDTO;
    }

    @Override
    public FavoriDTO updateFavori(Integer id, FavoriDTO favoriDTO) {return null;}

    @Override
    public FavoriDTO getFavoriByTitle(String title) {
        Favorisadd favori = favoriRepository.findByTitle(title).get();
        FavoriDTO favoriDTO = new FavoriDTO();
        BeanUtils.copyProperties(favori, favoriDTO);
        return favoriDTO;
    }
}
