package com.bingewatch.service.user.microservicebingewatchuser.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(of = {"idRole","typeRole"} )
@EqualsAndHashCode(of = {"idRole", "typeRole" })
@Entity
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_role")
    private Long idRole;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name="type_role")
    private TypeRole typeRole;
}
