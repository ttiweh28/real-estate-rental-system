package group3_real_estate_rental_system.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

//@RestControllerAdvice
public class GlobalExceptionHandler {

    //  @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
