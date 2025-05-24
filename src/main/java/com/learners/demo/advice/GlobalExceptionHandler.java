package com.learners.demo.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // Handles @Valid failure exceptions
    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseEntity<String> handleGeneralException(HttpMessageConversionException ex) {
        logger.debug("## Failed with HttpMessageConversionException ##");
        HttpHeaders headers = new HttpHeaders();
        headers.add("cache-control", "no-cache, no-store, must-revalidate");
        return new ResponseEntity<>("Internal server error", headers, HttpStatus.BAD_REQUEST);
    }

    // Handles @Valid failure exceptions
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleGeneralException(RuntimeException ex) {
        logger.debug("## Failed with RuntimeException ##");
        HttpHeaders headers = new HttpHeaders();
        headers.add("cache-control", "no-cache, no-store, must-revalidate");
        return new ResponseEntity<>("Internal server error", headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        logger.debug("## Failed with Exception ##");
        HttpHeaders headers = new HttpHeaders();
        headers.add("cache-control", "no-cache, no-store, must-revalidate");
        return new ResponseEntity<>("Internal server error", headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
