package com.bingewatch.service.user.microservicebingewatchuser;

import com.bingewatch.service.user.microservicebingewatchuser.dto.FavoriDTO;
import com.bingewatch.service.user.microservicebingewatchuser.dto.UserDTO;
import com.bingewatch.service.user.microservicebingewatchuser.entity.Favori;
import com.bingewatch.service.user.microservicebingewatchuser.entity.Role;
import com.bingewatch.service.user.microservicebingewatchuser.entity.User;
import com.bingewatch.service.user.microservicebingewatchuser.service.FavoriService;
import com.bingewatch.service.user.microservicebingewatchuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@SpringBootApplication
public class MicroserviceBingewatchUserApplication implements CommandLineRunner {

    @Autowired
    FavoriService favoriservice;
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceBingewatchUserApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        FavoriDTO favori = new FavoriDTO(1, "Titre de la série", "Synopsis de la série", 1, 1, "France");
        favori = new FavoriDTO(2, "Game of thrones", "Synopsis avec des dragons", 10, 7, "US");
        favoriservice.createFavori(favori);

        System.out.println(favoriservice.getAllFavoris());

        //UserDTO user = new UserDTO(1, "Low", "lokrinbarg@gmail.com", Role.USER, );
        //userService.createUser(user);

        //System.out.println(userService.getAllUsers());
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/favoris").allowedOrigins("http://localhost:4200");
            }
        };
    }
}
