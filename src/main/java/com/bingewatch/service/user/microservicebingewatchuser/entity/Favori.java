package com.bingewatch.service.user.microservicebingewatchuser.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "favoris")
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Favori {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "favori_generator")
    private Integer id;
    private String name;
    private String overview;
    private Date first_air_date;
    private Integer popularity;
    private String poster_path;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @ToString.Exclude
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Favori favori = (Favori) o;
        return id != null && Objects.equals(id, favori.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}


