package dev.ngb.base_project.example.domain;

import dev.ngb.base_project.example.Example;

/**
 * Projection for {@link Example}
 */
public interface ExampleProjection {
    Long getId();

    String getName();

    String getDescription();
}