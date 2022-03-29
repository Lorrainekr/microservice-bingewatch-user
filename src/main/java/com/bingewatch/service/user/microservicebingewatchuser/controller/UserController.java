package com.bingewatch.service.user.microservicebingewatchuser.controller;
import com.bingewatch.service.user.microservicebingewatchuser.dao.FavoriaddRepository;
import com.bingewatch.service.user.microservicebingewatchuser.model.Favorisadd;
import com.bingewatch.service.user.microservicebingewatchuser.model.User;
import com.bingewatch.service.user.microservicebingewatchuser.model.dto.Request;
import com.bingewatch.service.user.microservicebingewatchuser.model.exception.FavoriFoundException;
import com.bingewatch.service.user.microservicebingewatchuser.model.exception.UserFoundException;
import com.bingewatch.service.user.microservicebingewatchuser.model.exception.UserNotFoundException;
import com.bingewatch.service.user.microservicebingewatchuser.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "*")
@Api(description = "API pour les opérations CRUD pour les user")
@RestController
public class UserController {
    private Logger log = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private UserService userService;

    @Autowired
    private FavoriaddRepository favoriaddRepository;

    @CrossOrigin
    @ApiOperation(value = "Ajout d'un user lambda")
    @PostMapping(path="/adduser")
    public ResponseEntity<String> addUser(@Valid @RequestBody User user) throws UserFoundException {
        log.info("addUser() est appelée");

        User adduser = userService.saveUserBasicInDB(user);

        return new ResponseEntity<String>("User registred",HttpStatus.OK);
    }

    @CrossOrigin
    @ApiOperation(value = "Ajout d'un favori")
    @PutMapping(path="/addfavorite")
    public void addFavorite(@Valid @RequestBody Request request ) throws FavoriFoundException {
        Optional<User> user;
        try {
            if (!favoriaddRepository.existsByName(request.getName())){
                user = userService.findByNameInDB(request.getUserName());
                System.out.println(user);
                System.out.println(request);

                Favorisadd favorisadd = new Favorisadd();
                favorisadd.setName(request.getName());
                favorisadd.setId(request.getId());
                favorisadd.setPoster_path(request.getPoster_path());
                favorisadd.setUser(user.get());
                user.get().getFavorisadd().add(favorisadd) ;
                userService.updateUser(user);
            }else {
                System.out.println("wtf");
            }
        } catch (UserNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "Ajout d'un user admin")
    @PostMapping(path="/addAdminUser")
    public ResponseEntity<Void> addAdminUser(@Valid @RequestBody User user) throws UserFoundException {
        log.info("addAdminUser() est appelée");
        User addAdminUser = userService.saveUserAdminInDB(user);
        if (addAdminUser == null)
            return ResponseEntity.noContent().build();
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{email}")
                .buildAndExpand(addAdminUser.getEmail())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
    @ApiOperation(value = "Recherche un user grâce à son email à condition que celui-ci existe.")
    @GetMapping(path="/searchUserMail/{email}")
    public Optional<User> searchUserByEmail(@PathVariable String email) throws UserNotFoundException {
        log.info("searchUserByEmail() est appelée");
        return userService.findByEmailInDB(email);
    }

    @GetMapping(path="/searchUserName/{name}")
    public Optional<User> searchUserByName(@PathVariable String name) throws UserNotFoundException {
        log.info("searchUserByEmail() est appelée");
        return userService.findByNameInDB(name);
    }

    @ApiOperation(value = "Recherche un user grâce à son id à condition que celui-ci existe.")
    @GetMapping(path="/searchUserId/{id}")
    public Optional<User> searchUserById(@PathVariable Long id) throws UserNotFoundException{
        log.info("searchUserById() est appelée");
        return userService.findByIdInDB(id);
    }
    @ApiOperation(value = "Recherche tous les users.")
    @GetMapping(path="/searchUser")
    public List<User> searchAllUser() throws UserNotFoundException {
        log.info("searchAllUser() est appelée");
        return userService.findAllInDB();
    }

    @ApiOperation(value = "Recherche tous les users admin.")
    @GetMapping(path="/searchAdmin")
    public List<User> searchAllAdmin() throws UserNotFoundException {
        log.info("searchAllAdmin() est appelée");
        return userService.findAllAdminInDB();
    }

    @ApiOperation(value = "Supprimer un user grâce à son ID à condition que celui-ci existe.")
    @DeleteMapping (path="/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id) throws UserNotFoundException {
        log.info("deleteUser() est appelée");
        userService.deleteUserInDB(id);
    }
    @ApiOperation(value = "Supprimer TOUS les users")
    @DeleteMapping (path="/deleteUser/all")
    public void deleteAllUsers() throws UserNotFoundException {
        log.info("deleteAllUsers() est appelée");
        userService.deleteAllUsersInDB();
    }
    @ApiOperation(value = "Modifier un user grâce à son ID à condition que celui-ci existe.")
    @PutMapping (path="/editUser/{id}")
    public void editUser(@RequestBody User user, @PathVariable Long id) throws UserNotFoundException {
        log.info("editUser() est appelée");
        userService.editUserInDB(user, id);
    }


    @ApiOperation(value = "Mon espace")
    @GetMapping(path="/monespace/{name}")
    public List<Request> monEspace(@PathVariable String name) throws UserNotFoundException {
        log.info("favoriByEmail() est appelée");
        Optional<User> user =userService.findByNameInDB(name);
        System.out.println(user.get().getEmail());
        List<Favorisadd> list = favoriaddRepository.findByUser(user.get());
        List<Request> requestlist = new ArrayList<Request>();
        for (Favorisadd fav : list) {
            Request req= new Request();
            req.setUserName(name);
            req.setId(fav.getId());
            req.setPoster_path(fav.getPoster_path());
            req.setName(fav.getName());
            requestlist.add(req);
        }
        return requestlist;
    }
    @CrossOrigin
    @ApiOperation(value = "Supprimer un favori")
    @PutMapping(path="deletefavorite/")
    public void deletefavorite(@RequestBody Request request) throws UserNotFoundException {
        log.info("deletefavoriByEmail() est appelée");
        Optional<User> user =userService.findByEmailInDB(request.getUserName());
        System.out.println(user.get().getEmail());
        Favorisadd fav=favoriaddRepository.findByIdAndUser(request.getId(),user.get());
        favoriaddRepository.delete(fav);
        System.out.println(user.get().getFavorisadd());

        userService.updateUser(user);


    }
}
