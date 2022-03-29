package com.bingewatch.service.user.microservicebingewatchuser.service;

import com.bingewatch.service.user.microservicebingewatchuser.model.dto.FavoriDTO;
import com.bingewatch.service.user.microservicebingewatchuser.model.dto.Request;
import com.bingewatch.service.user.microservicebingewatchuser.model.exception.FavoriFoundException;

import java.util.List;

public interface FavoriService {
    public List<FavoriDTO> getAllFavoris();
    public FavoriDTO getFavori(Integer id);
    public FavoriDTO getFavoriByTitle(String title);
    public void deleteFavori(Integer id);
    public FavoriDTO createFavori(FavoriDTO favoriDTO);
    public FavoriDTO updateFavori(Integer id, FavoriDTO favoriDTO);
    public Boolean Favorinotexist(Request request) throws FavoriFoundException;
}
