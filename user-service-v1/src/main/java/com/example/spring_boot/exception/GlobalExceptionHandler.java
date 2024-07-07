package com.example.spring_boot.exception;

import com.example.spring_boot.model.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiResponse<String>> handleUserNotFoundException (UserNotFoundException ex) {
        ApiResponse<String> apiResponse = new ApiResponse<>("Error", ex.getMessage(), null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }

    @ExceptionHandler
    public ResponseEntity<ApiResponse<String>> handleGeneralException (Exception ex) {
        ApiResponse<String> apiResponse = new ApiResponse<>("error", "An unexcepted error occurred", null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
    }

}
