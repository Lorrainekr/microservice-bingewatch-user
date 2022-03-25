package com.bingewatch.service.user.microservicebingewatchuser.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
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
    @Column(name = "Encoded_Password", length = 128, nullable = false)
    protected String encodedPassword;
    private Role role;

    @OneToMany
    private List<Favori> favoris = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", pseudo='" + pseudo + '\'' +
                ", email='" + email + '\'' +
                ", encodedPassword='" + encodedPassword + '\'' +
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
                && Objects.equals(encodedPassword, user.encodedPassword)
                && role == user.role && Objects.equals(favoris, user.favoris);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, pseudo, email, encodedPassword, role, favoris);
    }
}
