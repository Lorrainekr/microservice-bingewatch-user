package com.bingewatch.service.user.microservicebingewatchuser.dto;

import com.bingewatch.service.user.microservicebingewatchuser.entity.Favori;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Objects;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FavoriDTO {
    private Integer id;
    private String titre;
    private String synopsis;
    //private Byte image;
    //@JsonFormat(pattern="yyyy")
    //private Date annee;
    private Integer nbreEpisode;
    private Integer nbrSaison;
    private String pays;

    @Override
    public String toString() {
        return "Favori{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", nbreEpisode=" + nbreEpisode +
                ", nbrSaison=" + nbrSaison +
                ", pays='" + pays + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoriDTO favoriDTO = (FavoriDTO) o;
        return Objects.equals(id, favoriDTO.id)
                && Objects.equals(titre, favoriDTO.titre)
                && Objects.equals(synopsis, favoriDTO.synopsis)
                && Objects.equals(nbreEpisode, favoriDTO.nbreEpisode)
                && Objects.equals(nbrSaison, favoriDTO.nbrSaison)
                && Objects.equals(pays, favoriDTO.pays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titre, synopsis, nbreEpisode, nbrSaison, pays);
    }
}
