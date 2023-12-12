package ma.youcode.aftas.exception;

import java.time.LocalDateTime;

public record ErrorResponse(
        Integer statusCode,
        String message,
        LocalDateTime timestamp,
        String errorCode,
        String path
) {
}
