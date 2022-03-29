package com.bingewatch.service.user.microservicebingewatchuser.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

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
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    //	@Email(regexp = "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b", message = "Regex email")
    private String email;
    private String password;
    private String name;
    private String surname;
    @DateTimeFormat(pattern = "dd-MM-yyyy' 'HH:mm" )
    private Date dateMaj;
    private Boolean isAdmin;

    @OneToOne
    private Role role;

    @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
    private Set<Favorisadd> favorisadd= new HashSet<>();

}
