package org.furstd.nnpiacv02.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<Object> handleCustomException(BaseException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("status", ex.getStatus().value());
        body.put("timestamp", ex.getTimestamp());
        body.put("error", ex.getStatus().getReasonPhrase());
        body.put("message", ex.getMessage());

        return new ResponseEntity<>(body, ex.getStatus());
    }
}
