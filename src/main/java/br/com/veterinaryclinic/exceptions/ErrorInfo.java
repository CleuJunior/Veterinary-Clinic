package br.com.veterinaryclinic.exceptions;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@JsonPropertyOrder({"status", "message", "timestamp"})
public class ErrorInfo  implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private final Instant timestamp;
    private final Integer status;
    private final String message;


    public ErrorInfo(Instant timestamp, Integer status, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
    }
}
