package com.example.spring_boot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ApiResponse<T> {

    private String status;
    private String message;

    private T data;

}
