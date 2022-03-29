package com.bingewatch.service.user.microservicebingewatchuser.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {
    private String userName;
    private Integer id;
    private String name;
    private String overview;
    private String poster_path;
    private Integer popularity;
    private String first_air_date;
}
