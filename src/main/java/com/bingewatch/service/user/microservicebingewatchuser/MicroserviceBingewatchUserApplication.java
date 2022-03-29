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
public class MicroserviceBingewatchUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceBingewatchUserApplication.class, args);
    }
}
