package com.example.learningcenter.exceptions.handler;

import com.example.learningcenter.dto.response.AppErrorDTO;
import com.example.learningcenter.dto.response.Data;
import com.example.learningcenter.exceptions.AlreadyExistException;
import com.example.learningcenter.exceptions.TargetDidNotFindException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity
                .badRequest()
                .body(ex
                        .getFieldErrors()
                        .stream()
                        .collect(Collectors.toMap(
                                FieldError::getField,
                                FieldError::getDefaultMessage
                        )));
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<Data<Object>> alreadyExistException(AlreadyExistException ex, WebRequest request) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Data
                        .builderError()
                        .error(
                                AppErrorDTO
                                        .secondBuilder()
                                        .message(ex.getLocalizedMessage())
                                        .status(HttpStatus.CONFLICT)
                                        .path(((ServletWebRequest) request).getRequest().getRequestURI())
                                        .build())
                        .build());
    }

    @ExceptionHandler(TargetDidNotFindException.class)
    public ResponseEntity<Data<Object>> targetDidNotFindException(TargetDidNotFindException ex, WebRequest request) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Data
                        .builderError()
                        .error(
                                AppErrorDTO
                                        .secondBuilder()
                                        .message(ex.getLocalizedMessage())
                                        .status(HttpStatus.CONFLICT)
                                        .path(((ServletWebRequest) request).getRequest().getRequestURI())
                                        .build())
                        .build());
    }
}
