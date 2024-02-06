package dev.ngb.base_project.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleRepository extends JpaRepository<Example, Long> {

    boolean existsByNameIgnoreCase(String name);
}