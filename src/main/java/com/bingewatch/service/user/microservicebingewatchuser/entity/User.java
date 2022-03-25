package com.bingewatch.service.user.microservicebingewatchuser.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @NotBlank
    private String pseudo;

    @NotBlank
    private String email;

    @Column(name = "Encoded_Password", length = 128, nullable = false)
    @NotBlank
    protected String encodedPassword;

    @NotBlank
    private Boolean loggedIn;

    @OneToOne
    private Role Role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Favori> favoris = new HashSet<>();

}
