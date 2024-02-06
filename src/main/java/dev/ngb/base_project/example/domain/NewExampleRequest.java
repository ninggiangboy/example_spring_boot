package dev.ngb.base_project.example.domain;

import dev.ngb.base_project.example.Example;
import jakarta.validation.constraints.NotBlank;

/**
 * DTO for {@link Example}
 */
public record NewExampleRequest(
        @NotBlank(message = "Name is required")
        String name,
        String description
) {
}
