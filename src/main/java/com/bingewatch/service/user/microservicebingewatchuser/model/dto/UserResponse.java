package com.bingewatch.service.user.microservicebingewatchuser.model.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    private Long id;
    private String email;
    private String password;
    private String role;
    private String name;
    private String surname;
    private String dateMaj;
    private Boolean isAdmin;

}
