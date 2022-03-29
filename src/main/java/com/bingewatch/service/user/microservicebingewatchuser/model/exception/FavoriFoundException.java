package com.bingewatch.service.user.microservicebingewatchuser.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND, reason = "favori already exist")
public class FavoriFoundException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

}
