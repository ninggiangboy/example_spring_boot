package dev.ngb.base_project.exception.handler;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record FormErrorResponse(
        int status,
        String path,
        @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
        LocalDateTime timestamp,
        String message,
        List<ValidationError> errors
) {
    @Builder
    public record ValidationError(
            String field,
            List<String> messages
    ) {
    }
}
