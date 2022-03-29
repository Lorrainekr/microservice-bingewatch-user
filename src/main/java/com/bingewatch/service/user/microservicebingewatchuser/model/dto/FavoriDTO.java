package com.bingewatch.service.user.microservicebingewatchuser.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class FavoriDTO {
    private Integer id;
    private String name;
    private String overview;
    private String poster_path;
    private Integer popularity;
    private String first_air_date;

}
