package com.workintech.zoo.zooOrganization.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(KangarooException.class)
    public ResponseEntity<KangarooErrorResponse> handleExceptionKangaroo(KangarooException kangarooException) {
        KangarooErrorResponse kangarooErrorResponse = new KangarooErrorResponse(
                kangarooException.getStatus().value(), kangarooException.getMessage(), System.currentTimeMillis()
        );
        return new ResponseEntity<>(kangarooErrorResponse, kangarooException.getStatus());
    }

    @ExceptionHandler(KoalaException.class)
    public ResponseEntity<KoalaErrorResponse> handleExceptionKoala(KoalaException koalaException) {
        KoalaErrorResponse koalaErrorResponse = new KoalaErrorResponse(
                koalaException.getStatus().value(), koalaException.getMessage(), System.currentTimeMillis()
        );
        return new ResponseEntity<>(koalaErrorResponse, koalaException.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<KangarooErrorResponse> handleGenericException(Exception exception) {
        KangarooErrorResponse kangarooErrorResponse = new KangarooErrorResponse(
                HttpStatus.BAD_REQUEST.value(), exception.getMessage(), System.currentTimeMillis()
        );
        log.error(exception.getMessage());
        return new ResponseEntity<>(kangarooErrorResponse, HttpStatus.BAD_REQUEST);
    }
}

