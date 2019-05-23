package pl.codementors.finalProject.Exceptions;

import java.time.LocalDateTime;

public class ExceptionResponse {

    private LocalDateTime timestamp;
    private String message;
    private String details;

    public ExceptionResponse(LocalDateTime now, String message, String description) {
    }
}
