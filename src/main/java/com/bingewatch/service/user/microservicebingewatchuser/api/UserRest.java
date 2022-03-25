package com.bingewatch.service.user.microservicebingewatchuser.api;
import com.bingewatch.service.user.microservicebingewatchuser.dto.UserDTO;
import com.bingewatch.service.user.microservicebingewatchuser.entity.Status;
import com.bingewatch.service.user.microservicebingewatchuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("/users/register")
    public Status registerUser(@Valid @RequestBody UserDTO newUser) {
        List<UserDTO> users = userService.getAllUsers();
        System.out.println("New user: " + newUser.toString());
        for (UserDTO user : users) {
            System.out.println("Registered user: " + newUser.toString());
            if (user.equals(newUser)) {
                System.out.println("User Already exists!");
                return Status.USER_ALREADY_EXISTS;
            }
        }
        userService.createUser(newUser);
        return Status.SUCCESS;
    }

    @PostMapping("/users/login")
    public Status loginUser(@Valid @RequestBody UserDTO userDTO) {
        List<UserDTO> users = userService.getAllUsers();
        for (UserDTO other : users) {
            if (other.equals(userDTO)) {
                userDTO.setLoggedIn(true);
                userService.save(userDTO);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
    }

    @PostMapping("/users/logout")
    public Status logUserOut(@Valid @RequestBody UserDTO userDTO) {
        List<UserDTO> users = userService.getAllUsers();
        for (UserDTO other : users) {
            if (other.equals(userDTO)) {
                userDTO.setLoggedIn(false);
                userService.save(userDTO);
                return Status.SUCCESS;
            }
        }
        return Status.FAILURE;
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
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO, @PathVariable String encodedPassword, @PathVariable String id) {
        UserDTO newUserDTO = userService.updateUser(userDTO, encodedPassword, id);

        return new ResponseEntity<UserDTO>(newUserDTO, HttpStatus.OK);
    }
}
