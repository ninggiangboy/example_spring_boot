package dev.ngb.base_project.example;

import dev.ngb.base_project.example.domain.ExampleResponse;
import dev.ngb.base_project.example.domain.NewExampleRequest;
import dev.ngb.base_project.example.domain.UpdateExampleRequest;
import dev.ngb.base_project.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExampleServiceImpl implements ExampleService {

    private final ExampleRepository exampleRepository;
    private final ExampleValidator exampleValidator;
    private final ModelMapper mapper;

    @Override
    public Page<ExampleResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return exampleRepository.findAll(pageable)
                .map((element) -> mapper.map(element, ExampleResponse.class));
    }

    @Override
    public ExampleResponse getById(Long id) {
        Example example = getByIdOrThrow(id);
        return mapper.map(example, ExampleResponse.class);
    }

    @Override
    public void create(NewExampleRequest newExample) {
        exampleValidator.validate(newExample);
        Example example = mapper.map(newExample, Example.class);
        exampleRepository.save(example);
    }

    @Override
    public void update(Long id, UpdateExampleRequest updateExample) {
        Example example = getByIdOrThrow(id);
        exampleValidator.validate(example, updateExample);
        mapper.map(updateExample, example);
        exampleRepository.save(example);
    }

    @Override
    public void delete(Long id) {
        Example example = getByIdOrThrow(id);
        example.setIsActive(false);
        exampleRepository.save(example);
    }

    private Example getByIdOrThrow(Long id) {
        return exampleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Example not found"));
    }
}
