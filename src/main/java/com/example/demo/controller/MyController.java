package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @PostMapping("api/test/url")
    public ResponseEntity<String> getResource(@RequestBody String s) {

        HttpStatus httpStatus = HttpStatus.OK;
        return new ResponseEntity<>(s, httpStatus);
    }

    @PostMapping("new/test/value")
    public ResponseEntity<String> getResource2(@RequestBody String s) {

        return new ResponseEntity<>(s, HttpStatus.OK);
    }
}
