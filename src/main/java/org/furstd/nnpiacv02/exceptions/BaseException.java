package org.furstd.nnpiacv02.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class BaseException extends RuntimeException {
    private final HttpStatus status;
    private final String message;
    private final ZonedDateTime timestamp;

    public BaseException(HttpStatus status, String message) {
        super(message);
        this.status = status;
        this.message = message;
        this.timestamp = ZonedDateTime.now();
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
