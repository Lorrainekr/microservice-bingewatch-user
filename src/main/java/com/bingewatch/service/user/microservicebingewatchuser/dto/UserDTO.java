package com.bingewatch.service.user.microservicebingewatchuser.dto;

import com.bingewatch.service.user.microservicebingewatchuser.entity.Favori;
import com.bingewatch.service.user.microservicebingewatchuser.entity.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserDTO {
    private Integer Id;
    private String pseudo;
    private String encodedPassword;
    private String email;
    private Boolean loggedIn;

    @OneToOne
    private Role Role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Favori> favoris = new HashSet<>();


}
