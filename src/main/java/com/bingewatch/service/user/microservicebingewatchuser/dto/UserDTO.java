package com.bingewatch.service.user.microservicebingewatchuser.dto;

import com.bingewatch.service.user.microservicebingewatchuser.entity.Favori;
import com.bingewatch.service.user.microservicebingewatchuser.entity.Role;
import com.bingewatch.service.user.microservicebingewatchuser.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.OneToMany;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

    private Integer Id;

    private String pseudo;
    private String encodedPassword;
    private String email;
    private Role role;

    @OneToMany
    private List<Favori> favoris;

    @Override
    public String toString() {
        return "UserDTO{" +
                "Id=" + Id +
                ", pseudo='" + pseudo + '\'' +
                ", encodedPassword='" + encodedPassword + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", favoris=" + favoris +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(Id, userDTO.Id)
                && Objects.equals(pseudo, userDTO.pseudo)
                && Objects.equals(encodedPassword, userDTO.encodedPassword)
                && Objects.equals(email, userDTO.email) && role == userDTO.role
                && Objects.equals(favoris, userDTO.favoris);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, pseudo, encodedPassword, email, role, favoris);
    }
}
