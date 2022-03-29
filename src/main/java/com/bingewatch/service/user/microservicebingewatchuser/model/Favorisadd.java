package com.bingewatch.service.user.microservicebingewatchuser.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class Favorisadd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY,optional=false)
    private User user;
    private String name;
    private String overview;
    private String poster_path;
    private Integer popularity;
    private String first_air_date;
}
