package dev.ngb.base_project.example.domain;

import dev.ngb.base_project.example.Example;

/**
 * DTO for {@link Example}
 */
public record NewExampleRequest(
        String name,
        String description
) {
}
