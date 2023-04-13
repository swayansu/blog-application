package com.swayansu.springdata.blogapplication.exceptions;
import com.swayansu.springdata.blogapplication.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException exception){
        String message = exception.getMessage();
        ApiResponse apiResponse = new ApiResponse(message, false);
        return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgsNotValidException(MethodArgumentNotValidException e){
        Map<String, String> resp = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(objectError -> {
            String fieldName = ((FieldError)objectError).getField();
            String errorMessage = objectError.getDefaultMessage();
            resp.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }
}
