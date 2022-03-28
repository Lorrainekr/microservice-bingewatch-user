package com.bingewatch.service.user.microservicebingewatchuser.restApiController;

import com.bingewatch.service.user.microservicebingewatchuser.configuration.ResourceNotFoundException;
import com.bingewatch.service.user.microservicebingewatchuser.entity.User;
import com.bingewatch.service.user.microservicebingewatchuser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String pseudo) {
        List<User> users = new ArrayList<User>();
        if (pseudo == null)
            users.addAll(userRepository.findAll());
        else
            users.addAll(userRepository.findByPseudo(pseudo));
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) throws ResourceNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found User with id = " + id));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users/{pseudo}")
    public ResponseEntity<User> getUserByPseudo(@PathVariable("pseudo") String pseudo) {
        User user = (User) userRepository.findByPseudo(pseudo);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User _user = userRepository.save(new User(user.getPseudo(), user.getEmail(), user.getEncodedPassword()));
        return new ResponseEntity<>(_user, HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) throws ResourceNotFoundException {
        User _user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found User with id = " + id));
        _user.setPseudo(user.getPseudo());
        _user.setEmail(user.getEmail());
        _user.setEncodedPassword(user.getEncodedPassword());
        return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUSer(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/users")
    public ResponseEntity<HttpStatus> deleteAllUsers() {
        userRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
