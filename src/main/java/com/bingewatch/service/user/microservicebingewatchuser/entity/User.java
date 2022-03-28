package com.bingewatch.service.user.microservicebingewatchuser.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name= "users")
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    private Integer id;
    @Column(name = "pseudo")
    private String pseudo;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String encodedPassword;

    public User(String pseudo, String email, String encodedPassword) {
    }
}
