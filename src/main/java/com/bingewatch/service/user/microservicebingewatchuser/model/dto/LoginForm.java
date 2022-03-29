package com.bingewatch.service.user.microservicebingewatchuser.model.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginForm {

    private String email;
    private String password;

}
