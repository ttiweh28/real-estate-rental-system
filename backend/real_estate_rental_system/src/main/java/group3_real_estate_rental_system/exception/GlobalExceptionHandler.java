package group3_real_estate_rental_system.exception;


import group3_real_estate_rental_system.common.BaseResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
public class GlobalExceptionHandler {
        // Handle Not Found (404) Exception
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<BaseResponse> handleNotFound(NoHandlerFoundException ex) {
        BaseResponse baseResponse = BaseResponse.failureResponse(ex.getMessage(), BaseResponse.class);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(baseResponse);
    }

    // Handle Bad Request (400) for validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BaseResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        BaseResponse baseResponse = BaseResponse.failureResponse(ex.getMessage(), BaseResponse.class);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(baseResponse);
    }

    // Handle Bad Request (401) for validation errors
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<BaseResponse> accessDeniedException(AccessDeniedException ex) {
        BaseResponse baseResponse = BaseResponse.failureResponse(ex.getMessage(), BaseResponse.class);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(baseResponse);
    }

    // Handle All Other Exceptions (500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        if (!request.getRequestURI().startsWith("/api/v3/api-docs") && !request.getRequestURI().startsWith("/swagger-ui")) {
            BaseResponse baseResponse = BaseResponse.failureResponse(ex.getMessage(), BaseResponse.class);
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(baseResponse);
        }
        return null;
    }

}
