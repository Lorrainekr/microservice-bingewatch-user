package com.bingewatch.service.user.microservicebingewatchuser.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
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
        Favori favori = (Favori) o;
        return Objects.equals(id, favori.id)
                && Objects.equals(titre, favori.titre)
                && Objects.equals(synopsis, favori.synopsis)
                && Objects.equals(nbreEpisode, favori.nbreEpisode)
                && Objects.equals(nbrSaison, favori.nbrSaison)
                && Objects.equals(pays, favori.pays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titre, synopsis, nbreEpisode, nbrSaison, pays);
    }
}


