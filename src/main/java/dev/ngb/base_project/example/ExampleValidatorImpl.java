package dev.ngb.base_project.example;

import dev.ngb.base_project.example.domain.NewExampleRequest;
import dev.ngb.base_project.example.domain.UpdateExampleRequest;
import dev.ngb.base_project.exception.ConflictException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExampleValidatorImpl implements ExampleValidator {

    private final ExampleRepository exampleRepository;

    @Override
    public void validate(NewExampleRequest newExample) {
        String newName = newExample.name();
        if (exampleRepository.existsByNameIgnoreCase(newName)) {
            throw new ConflictException("Example with name " + newName + " already exists");
        }
    }

    @Override
    public void validate(Example existExample, UpdateExampleRequest updateExample) {
        String newName = updateExample.name();
        String oldName = existExample.getName();

        if (!newName.equalsIgnoreCase(oldName) && exampleRepository.existsByNameIgnoreCase(newName)) {
            throw new ConflictException("Example with name " + newName + " already exists");
        }
    }
}
