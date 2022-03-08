package com.bingewatch.service.user.microservicebingewatchuser.api;

import com.bingewatch.service.user.microservicebingewatchuser.dto.FavoriDTO;
import com.bingewatch.service.user.microservicebingewatchuser.entity.Favori;
import com.bingewatch.service.user.microservicebingewatchuser.service.FavoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class FavoriRest {

    @Autowired
    private FavoriService favoriService;

    @GetMapping(path = "/favoris")
    public List<FavoriDTO> getAllFavoris() { return favoriService.getAllFavoris();}

    @PostMapping(path = "/favoris")
    public ResponseEntity<FavoriDTO> createFavori(@RequestBody FavoriDTO favoriDTO) {
        FavoriDTO newfavoriDto = favoriService.createFavori(favoriDTO);
        return new ResponseEntity<FavoriDTO>(newfavoriDto, HttpStatus.OK);
    }

    @GetMapping(path = "/favoris/{id}")
    public ResponseEntity<FavoriDTO> getFavori(@PathVariable Integer id) {
        FavoriDTO favoriDTO = favoriService.getFavori(id);
        return new ResponseEntity<FavoriDTO>(favoriDTO, HttpStatus.OK);
    }

    @DeleteMapping(path = "/favoris/{id}")
    public ResponseEntity<Void> deleteFavori(@PathVariable Integer id) {
        favoriService.deleteFavori(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/favoris/{id}")
    public ResponseEntity<FavoriDTO> updateFavori(@PathVariable Integer id, @RequestBody FavoriDTO favoriDTO) {
        FavoriDTO newFavoriDTO = favoriService.updateFavori(id, favoriDTO);

        return new ResponseEntity<FavoriDTO>(newFavoriDTO, HttpStatus.OK);
    }
}
