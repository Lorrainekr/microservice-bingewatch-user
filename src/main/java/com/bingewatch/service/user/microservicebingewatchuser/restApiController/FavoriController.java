package com.bingewatch.service.user.microservicebingewatchuser.restApiController;

import com.bingewatch.service.user.microservicebingewatchuser.configuration.ResourceNotFoundException;
import com.bingewatch.service.user.microservicebingewatchuser.entity.Favori;
import com.bingewatch.service.user.microservicebingewatchuser.entity.User;
import com.bingewatch.service.user.microservicebingewatchuser.repository.FavoriRepository;
import com.bingewatch.service.user.microservicebingewatchuser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class FavoriController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FavoriRepository favoriRepository;
    @GetMapping("/users/{userId}/favoris")
    public ResponseEntity<List<Favori>> getAllFavoriByUSerId(@PathVariable(value = "user_id") Integer userId) throws ResourceNotFoundException {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("Not found User with id = " + userId);
        }
        List<Favori> favoris = favoriRepository.findByUserId(userId);
        return new ResponseEntity<>(favoris, HttpStatus.OK);
    }

    @GetMapping("/favoris/{id}")
    public ResponseEntity<Favori> getFavorisByUSerId(@PathVariable(value = "id") Integer id) throws ResourceNotFoundException {
        Favori favori = favoriRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Favori with id = " + id));
        return new ResponseEntity<>(favori, HttpStatus.OK);
    }

    @PostMapping("/users/{usersId}/favoris")
    public ResponseEntity<Favori> createFavori(@PathVariable(value = "user_id") Integer userId,
                                               @RequestBody Favori favoriRequest) throws ResourceNotFoundException {
        Favori favori = userRepository.findById(userId).map(user -> {
            favoriRequest.setUser(user);
            return favoriRepository.save(favoriRequest);
        }).orElseThrow(() -> new ResourceNotFoundException("Not found USer with id = " + userId));
        return new ResponseEntity<>(favori, HttpStatus.CREATED);
    }
    @PutMapping("/favoris/{id}")
    public ResponseEntity<Favori> updateFavori(@PathVariable("id") Integer id,
                                               @RequestBody Favori favoriRequest) throws ResourceNotFoundException {
        Favori favori = favoriRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FavoriId " + id + "not found"));
        favori.setName(favoriRequest.getName());
        return new ResponseEntity<>(favoriRepository.save(favori), HttpStatus.OK);
    }
    @DeleteMapping("/favoris/{id}")
    public ResponseEntity<HttpStatus> deleteFavori(@PathVariable("id") Integer id) {
        favoriRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/users/{userId}/favoris")
    public ResponseEntity<List<Favori>> deleteAllFavoriOfUSer(@PathVariable(value = "userId") Integer userId) throws ResourceNotFoundException {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException("Not found Tutorial with id = " + userId);
        }
        favoriRepository.deleteByUserId(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
