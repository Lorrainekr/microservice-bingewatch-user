package com.bingewatch.service.user.microservicebingewatchuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroserviceBingewatchUserApplication implements CommandLineRunner {

    @Autowired
    //FavoriService favoriservice;
    //UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceBingewatchUserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //FavoriDTO favori = new FavoriDTO(1, "Titre de la série", "Synopsis de la série", 1, 1, "France");
        //favori = new FavoriDTO(2, "Game of thrones", "Synopsis avec des dragons", 10, 7, "US");
        //favoriservice.createFavori(favori);

        //System.out.println(favoriservice.getAllFavoris());

        //UserDTO user = new UserDTO(1, "Low", "lokrinbarg@gmail.com", Role.USER, );
        //userService.createUser(user);

        //System.out.println(userService.getAllUsers());
    }
}
