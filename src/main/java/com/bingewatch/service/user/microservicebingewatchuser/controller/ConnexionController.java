package com.bingewatch.service.user.microservicebingewatchuser.controller;

import com.bingewatch.service.user.microservicebingewatchuser.dao.UserRepository;
import com.bingewatch.service.user.microservicebingewatchuser.model.User;
import com.bingewatch.service.user.microservicebingewatchuser.model.dto.LoginForm;
import com.bingewatch.service.user.microservicebingewatchuser.model.dto.UserResponse;
import com.bingewatch.service.user.microservicebingewatchuser.model.exception.UserNotFoundException;
import com.bingewatch.service.user.microservicebingewatchuser.service.ConnexionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(value = "*")
@Api(description = "API pour les connexions User")
@RestController
@RequestMapping(path="/login")
public class ConnexionController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ConnexionService connexionService;

    @Autowired
    private UserRepository userRepository;


    @ApiOperation(value = "signIn")
    @PostMapping(path="/signin")
    @CrossOrigin
    public ResponseEntity<UserResponse> authenticateUser(@RequestBody LoginForm loginForm) throws UserNotFoundException {
        log.info("authenticateUser() est appelée");

        return connexionService.getAuthenticateUser(loginForm);
    }

    @ApiOperation(value = "id")
    @GetMapping(path="/{email}")
    @CrossOrigin
    public String getiduser(@PathVariable("email") String email) throws UserNotFoundException {
        Optional<User> findUser = userRepository.findByEmail(email);
        String id= findUser.get().getId().toString();

        return id;
    }

//	@ApiOperation(value = "signUp")
//	@PostMapping(path="/signup")
//	public ResponseEntity<LoginForm> createUserForAuthenticate(@RequestBody User user) throws UserNotFoundException {
//		log.info("authenticateUser() est appelée");
//
//		return connexionService.getCreateUserPlateforme(loginForm);
//	}





}
