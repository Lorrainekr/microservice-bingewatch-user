package com.bingewatch.service.user.microservicebingewatchuser.model.dto;

import com.bingewatch.service.user.microservicebingewatchuser.model.Favori;
import com.bingewatch.service.user.microservicebingewatchuser.model.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

@FieldDefaults(level= AccessLevel.PRIVATE)
@Getter
@Setter
public class RegisterDTO {

    private String name;
    private String password;

}
