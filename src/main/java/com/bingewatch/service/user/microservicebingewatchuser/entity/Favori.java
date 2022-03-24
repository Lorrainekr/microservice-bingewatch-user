package com.bingewatch.service.user.microservicebingewatchuser.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Favori {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String overview;
    private String poster_path;
    private Integer popularity;
    private String first_air_date;

    @Override
    public String toString() {
        return "Favori{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", overview='" + overview + '\'' +
                ", poster_path='" + poster_path + '\'' +
                ", popularity=" + popularity +
                ", first_air_date=" + first_air_date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Favori favori = (Favori) o;
        return Objects.equals(id, favori.id) && Objects.equals(name, favori.name) && Objects.equals(overview, favori.overview) && Objects.equals(poster_path, favori.poster_path) && Objects.equals(popularity, favori.popularity) && Objects.equals(first_air_date, favori.first_air_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, overview, poster_path, popularity, first_air_date);
    }
}


