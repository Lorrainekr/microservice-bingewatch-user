package com.bingewatch.service.user.microservicebingewatchuser;

import com.bingewatch.service.user.microservicebingewatchuser.service.FavoriService;
import com.bingewatch.service.user.microservicebingewatchuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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


        System.out.println(favoriservice.getAllFavoris());

       //UserDTO user = new UserDTO(1,"Low","1234","lokrinbarg@gmail.com",true, Status.SUCCESS, new ArrayList<>());
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
