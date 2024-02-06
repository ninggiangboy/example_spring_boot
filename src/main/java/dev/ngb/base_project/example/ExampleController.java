package dev.ngb.base_project.example;

import dev.ngb.base_project.base.BaseController;
import dev.ngb.base_project.base.ResultResponse;
import dev.ngb.base_project.example.domain.ExampleResponse;
import dev.ngb.base_project.example.domain.NewExampleRequest;
import dev.ngb.base_project.example.domain.UpdateExampleRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/examples")
@RequiredArgsConstructor
@Slf4j
public class ExampleController extends BaseController {

    private final ExampleService exampleService;

    @GetMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity<ResultResponse> getAll(
            @RequestParam(required = false, name = "page", defaultValue = "1") int page,
            @RequestParam(required = false, name = "per_page", defaultValue = "10") int size
    ) {
        Page<ExampleResponse> examples = exampleService.getAll(page, size);
        return buildResponse("Get All", examples, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<ResultResponse> getById(
            @PathVariable(name = "id") Long id
    ) {
        ExampleResponse example = exampleService.getById(id);
        return buildResponse("Get By Id", example, HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity<ResultResponse> create(
            @Valid @RequestBody NewExampleRequest newExample
    ) {
        exampleService.create(newExample);
        return buildResponse("Create", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<ResultResponse> update(
            @PathVariable(name = "id") Long id,
            @Valid @RequestBody UpdateExampleRequest updateExample
    ) {
        exampleService.update(id, updateExample);
        return buildResponse("Update", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<ResultResponse> delete(
            @PathVariable(name = "id") Long id
    ) {
        exampleService.delete(id);
        return buildResponse("Delete", HttpStatus.NO_CONTENT);
    }
}
