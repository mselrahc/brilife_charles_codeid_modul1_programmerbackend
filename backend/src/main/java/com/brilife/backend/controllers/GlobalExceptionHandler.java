package com.brilife.backend.controllers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.brilife.backend.models.ResponseMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
  private static final Logger exceptionLogger = LoggerFactory.getLogger(
    GlobalExceptionHandler.class
  );

  @Override
  public ResponseEntity<Object> handleMethodArgumentNotValid(
    MethodArgumentNotValidException e,
    HttpHeaders headers,
    HttpStatus status,
    WebRequest request
  ) {
    Map<String, List<String>> errors = e
      .getBindingResult()
      .getFieldErrors()
      .stream()
      .collect(
        Collectors.groupingBy(
          FieldError::getField,
          Collectors.mapping(FieldError::getDefaultMessage, Collectors.toList())
        )
      );
    errors.putAll(
      e
        .getBindingResult()
        .getGlobalErrors()
        .stream()
        .collect(
          Collectors.groupingBy(
            error -> error.getArguments()[2].toString(),
            Collectors.mapping(
              ObjectError::getDefaultMessage,
              Collectors.toList()
            )
          )
        )
    );

    ResponseMessage<Object> body = ResponseMessage.error(
      1,
      "Data tidak valid",
      errors
    );
    return ResponseEntity.ok(body);
  }


  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<ResponseMessage<Object>> handleIntegrityException(
    DataIntegrityViolationException e
  ) {
    ResponseMessage<Object> body = ResponseMessage.error(
      1,
      "Data tidak valid"
    );
    return ResponseEntity.ok(body);
  }


  @ExceptionHandler(Exception.class)
  public ResponseEntity<ResponseMessage<Object>> handleUnknownException(
    Exception e
  ) {
    exceptionLogger.error(e.getMessage(), e);
    ResponseMessage<Object> body = ResponseMessage.error(
      -1,
      e.getMessage(),
      null
    );
    return ResponseEntity.ok(body);
  }
}
