package com.bingewatch.service.user.microservicebingewatchuser.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FavoriDTO {
    private Integer id;
    private String name;
    private String overview;
    private String poster_path;
    private Integer popularity;
    private String first_air_date;

    @Override
    public String toString() {
        return "FavoriDTO{" +
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
        FavoriDTO favoriDTO = (FavoriDTO) o;
        return Objects.equals(id, favoriDTO.id) && Objects.equals(name, favoriDTO.name) && Objects.equals(overview, favoriDTO.overview) && Objects.equals(poster_path, favoriDTO.poster_path) && Objects.equals(popularity, favoriDTO.popularity) && Objects.equals(first_air_date, favoriDTO.first_air_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, overview, poster_path, popularity, first_air_date);
    }
}
