package ma.youcode.aftas.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDateTime;


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleException(Exception ex, WebRequest request) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex, "UNEXPECTED_ERROR", request);
    }
    @ExceptionHandler(InvalidDataException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse>handleInvalidDataException(InvalidDataException ex , WebRequest request) {
        return buildErrorResponse(HttpStatus.BAD_REQUEST, ex, "INVALID_DATA", request);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, ex, "RESOURCE_NOT_FOUND", request);
    }
    @ExceptionHandler(DatabaseAccessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse>handleDatabaseAccessException(DatabaseAccessException ex, WebRequest request){
        return  buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex,"DATABASE_ACCESS_ERROR",request);
    }
    @ExceptionHandler(ConcurrentUpdateException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ErrorResponse>handlConcurrentUpdateException(ConcurrentUpdateException ex, WebRequest request) {
        return  buildErrorResponse(HttpStatus.CONFLICT,ex,"CONCURRENT_UPDATE", request);
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(HttpStatus status, Exception ex, String errorCode, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                status.value(),
                ex.getMessage(),
                LocalDateTime.now(),
                errorCode,
                request.getDescription(false)
        );
        return ResponseEntity.status(status).body(errorResponse);
    }
}
