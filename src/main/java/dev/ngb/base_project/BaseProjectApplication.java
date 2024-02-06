package dev.ngb.base_project;

import dev.ngb.base_project.example.Example;
import dev.ngb.base_project.example.ExampleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class BaseProjectApplication implements CommandLineRunner {

    private final ExampleRepository exampleRepository;

    public static void main(String[] args) {
        SpringApplication.run(BaseProjectApplication.class, args);
    }

    @Override
    public void run(String... args) {
        if (exampleRepository.count() == 0) {
            exampleRepository.saveAll(List.of(
                    Example.builder().id(1L).name("Example 1").description("Description 1").isActive(true).build(),
                    Example.builder().id(2L).name("Example 2").description("Description 2").isActive(true).build(),
                    Example.builder().id(3L).name("Example 3").description("Description 3").isActive(true).build()
            ));
            log.info("Examples created");
        }
        log.info("Examples: {}", exampleRepository.findAll());
    }
}
