package com.abach42.payaraerror.endpoint;

import com.abach42.payaraerror.error.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class SomeController {

    @GetMapping("/notfound")
    public ResponseEntity<ErrorDto> getNotFound() {
        ErrorDto error = new ErrorDto("Resource not found");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/unauthorized")
    public ResponseEntity<ErrorDto> getUnauthorized() {
        ErrorDto error = new ErrorDto("Not authorized");
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }
}
