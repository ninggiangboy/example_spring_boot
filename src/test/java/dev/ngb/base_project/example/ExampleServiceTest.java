package dev.ngb.base_project.example;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@RequiredArgsConstructor
class ExampleServiceTest {

    private final ExampleService exampleService;
    @MockBean
    private ExampleRepository repository;

    @BeforeEach
    void setUp() {
        Mockito.when(repository.findAll())
                .thenReturn(null);
    }

    @Test
    void getAll() {
    }

    @Test
    void getById() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}