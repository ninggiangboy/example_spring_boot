package dev.ngb.base_project.example;

import dev.ngb.base_project.example.domain.NewExampleRequest;
import dev.ngb.base_project.example.domain.UpdateExampleRequest;

public interface ExampleValidator {

    void validate(NewExampleRequest newExample);

    void validate(Example existExample, UpdateExampleRequest updateExample);
}
