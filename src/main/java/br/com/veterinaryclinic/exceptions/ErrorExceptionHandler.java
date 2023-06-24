package br.com.veterinaryclinic.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ErrorExceptionHandler {

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<ErrorInfo> entityNotFound(NotFoundException exception) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorInfo err = ErrorInfo.builder()
                .timestamp(Instant.now())
                .status(status.value())
                .message(exception.getMessage())
                .build();

        return ResponseEntity.status(status).body(err);
    }
}