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
public class User {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String pseudo;
    private String email;
    private Byte [] encodedPassword;
    private String motDePasse;
    private Role role;

    @OneToMany
    private List<Favori> favoris;

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", pseudo='" + pseudo + '\'' +
                ", email='" + email + '\'' +
                ", encodedPassword=" + Arrays.toString(encodedPassword) +
                ", motDePasse='" + motDePasse + '\'' +
                ", role=" + role +
                ", favoris=" + favoris +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(Id, user.Id)
                && Objects.equals(pseudo, user.pseudo)
                && Objects.equals(email, user.email)
                && Arrays.equals(encodedPassword, user.encodedPassword)
                && Objects.equals(motDePasse, user.motDePasse)
                && role == user.role && Objects.equals(favoris, user.favoris);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(Id, pseudo, email, motDePasse, role, favoris);
        result = 31 * result + Arrays.hashCode(encodedPassword);
        return result;
    }
}
