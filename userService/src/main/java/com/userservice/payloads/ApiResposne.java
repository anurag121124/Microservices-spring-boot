package com.userservice.payloads;

import lombok.*;
import org.springframework.http.HttpStatus;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ApiResposne {

    private String message;
    public boolean success;

    public HttpStatus status;

}
