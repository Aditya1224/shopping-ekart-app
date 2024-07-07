package com.example.spring_boot.model.error;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ErrorResponse {

    private String status;
    private String message;
    private List<String> errors;


}
