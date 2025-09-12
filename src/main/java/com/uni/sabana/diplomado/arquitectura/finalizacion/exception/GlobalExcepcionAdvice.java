package com.uni.sabana.diplomado.arquitectura.finalizacion.exception;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class GlobalExcepcionAdvice {


    @ExceptionHandler(DuplicatedObjectDataException.class)
    public ResponseEntity<String> handleDuplicatedObjectDataException(DuplicatedObjectDataException ex) {
        log.error("DuplicatedObjectDataException: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<String> handleObjectNotFoundException(ObjectNotFoundException ex) {
        log.error("ObjectNotFoundException: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(FirmaNoValidaException.class)
    public ResponseEntity<String> handleFirmaNoValidaException(FirmaNoValidaException ex) {
        log.error("FirmaNoValidaException: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


    @ExceptionHandler(NoSuchAlgorithmException.class)
    public ResponseEntity<String> handleNoSuchAlgorithmException(NoSuchAlgorithmException ex) {
        log.error("NoSuchAlgorithmException: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(InvalidKeyException.class)
    public ResponseEntity<String> handleInvalidKeyException(InvalidKeyException ex) {
        log.error("InvalidKeyException: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseExceptionModel> handleConstraintViolationException(ConstraintViolationException ex) {

        String errorMessage = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.joining(", "));

        log.error("ConstraintViolationException: {}", errorMessage);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ResponseExceptionModel
                        .builder()
                        .message(errorMessage)
                        .code(HttpStatus.BAD_REQUEST.value())
                        .timestamp(String.valueOf(System.currentTimeMillis()))
                        .build()
                );
    }


    @ExceptionHandler(ObjectSaveException.class)
    public ResponseEntity<ResponseExceptionModel> handleObjectSaveException(ObjectSaveException ex) {
        log.error("ObjectSaveException: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ResponseExceptionModel.builder()
                        .message(ex.getMessage())
                        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .timestamp(String.valueOf(System.currentTimeMillis()))
                        .build()
        );
    }

    @ExceptionHandler(ObjectUpdateException.class)
    public ResponseEntity<String> handleObjectUpdateException(ObjectUpdateException ex) {
        log.error("ObjectUpdateException: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.error("IllegalArgumentException: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }


    @ExceptionHandler(ObjectFindException.class)
    public ResponseEntity<String> handleObjectFindException(ObjectFindException ex) {
        log.error("ObjectFindException: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }



    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseExceptionModel> handleException(Exception ex) {
        log.error("Exception: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                ResponseExceptionModel.builder()
                        .message(ex.getMessage())
                        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .timestamp(String.valueOf(System.currentTimeMillis()))
                        .build()
        );
    }


}
