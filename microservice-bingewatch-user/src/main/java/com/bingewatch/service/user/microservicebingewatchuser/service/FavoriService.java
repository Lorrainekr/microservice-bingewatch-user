package com.bingewatch.service.user.microservicebingewatchuser.service;

import com.bingewatch.service.user.microservicebingewatchuser.dto.FavoriDTO;

import java.util.List;

public interface FavoriService {
    public List<FavoriDTO> getAllFavoris();
    public FavoriDTO getFavori(Integer id);
    public void deleteFavori(Integer id);
    public FavoriDTO createFavori(FavoriDTO favoriDTO);
    public FavoriDTO updateFavori(Integer id, FavoriDTO favoriDTO);
}
