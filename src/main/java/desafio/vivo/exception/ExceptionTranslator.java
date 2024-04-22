package desafio.vivo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionTranslator {

    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handleUserNotFoundException(UserNotFoundException e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        Map<String, String> response = new HashMap<>();
        response.put("message", e.getMessage());
        response.put("status", status.toString());
        return ResponseEntity.status(status).body(response);
    }
}
