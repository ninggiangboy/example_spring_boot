package dev.ngb.base_project.example;

import dev.ngb.base_project.example.domain.ExampleResponse;
import dev.ngb.base_project.example.domain.NewExampleRequest;
import dev.ngb.base_project.example.domain.UpdateExampleRequest;
import org.springframework.data.domain.Page;

public interface ExampleService {

    Page<ExampleResponse> getAll(int page, int size);

    ExampleResponse getById(Long id);

    void create(NewExampleRequest newExample);

    void update(Long id, UpdateExampleRequest updateExample);

    void delete(Long id);
}
