package dev.ngb.base_project.example.domain;

import dev.ngb.base_project.example.Example;
import lombok.Data;

/**
 * DTO for {@link Example}
 */
@Data
public class ExampleResponse {
    private Long id;
    private String name;
    private String description;
}