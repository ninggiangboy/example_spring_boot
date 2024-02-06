package dev.ngb.base_project.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record PageInfo(
        Integer page,
        @JsonProperty("per_page")
        Integer limit,
        @JsonProperty("total_elements")
        Long totalElements,
        @JsonProperty("total_pages")
        Integer totalPages,
        @JsonProperty("has_prev")
        Boolean hasPrev,
        @JsonProperty("has_next")
        Boolean hasNext
) {
}
