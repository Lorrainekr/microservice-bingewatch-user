package com.bingewatch.service.user.microservicebingewatchuser.api;
import com.bingewatch.service.user.microservicebingewatchuser.dto.UserDTO;
import com.bingewatch.service.user.microservicebingewatchuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserRest {

    @Autowired
    private UserService userService;
// Lister tout les users
    @GetMapping(path = "/users")
    public List<UserDTO> getAllUsers() { return userService.getAllUsers();}
// créer un user
    @PostMapping(path = "/users")
    public ResponseEntity<UserDTO> createUSer(@RequestBody UserDTO userDTO) {
        UserDTO newuserDto = userService.createUser(userDTO);
        return new ResponseEntity<UserDTO>(newuserDto, HttpStatus.OK);
    }

// une méthode "connexion (username, pwd) => vérifie si le user existe et si son pwd est celui de la bdd (valide)"
    @GetMapping(path = "/users/pseudo")
    public ResponseEntity<UserDTO> connexion(@PathVariable String pseudo, @PathVariable String encodedPassword) {
        // algo pour cherhcer le user et véifier son mot de passe
        // si ok -> le user en question
        // sinon -> erreur 403 (unauthorizecd)
        return null;
    }



// chercher un user par id
    @GetMapping(path = "/users/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Integer id) {
        UserDTO userDTO = userService.getUser(id);
        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
    }
// Supprimer un user avec son id
    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
// Mettre a jour un user
    @PutMapping(path = "/users/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        UserDTO newUserDTO = userService.updateUser(id, userDTO);

        return new ResponseEntity<UserDTO>(newUserDTO, HttpStatus.OK);
    }
}
