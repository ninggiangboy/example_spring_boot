package dev.ngb.base_project.base;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
public class BaseController {

    protected ResponseEntity<ResultResponse> buildResponse(String message, Object result, HttpStatus status) {
//        if (result == null) {
//            result = new ArrayList<>();
//        } else {
//            result = result instanceof Page<?> page ? getPageInfo(page) : Map.of("data", result);
//        }

        result = Optional.ofNullable(result)
                .map(r -> r instanceof Page<?> page ? getPageInfo(page) : Map.of("data", r))
                .orElse(Map.of());

        return ResponseEntity.status(status).body(
                ResultResponse.builder()
                        .result(result)
                        .message(message)
                        .status(status.value())
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    private Map<String, Object> getPageInfo(Page<?> page) {
        return Map.of(
                "data", page.getContent(),
                "page_meta", PageInfo.builder()
                        .limit(page.getSize())
                        .page(page.getNumber() + 1)
                        .totalElements(page.getTotalElements())
                        .totalPages(page.getTotalPages())
                        .hasNext(page.hasNext())
                        .hasPrev(page.hasPrevious())
                        .build()
        );
    }

    protected ResponseEntity<ResultResponse> buildResponse(String message, Object result) {
        return buildResponse(message, result, HttpStatus.OK);
    }

    protected ResponseEntity<ResultResponse> buildResponse(String message, HttpStatus status) {
        return buildResponse(message, null, status);
    }

    protected ResponseEntity<ResultResponse> buildResponse(String message) {
        return buildResponse(message, null, HttpStatus.OK);
    }

    protected ResponseEntity<ResultResponse> buildResponse() {
        return buildResponse("", null, HttpStatus.OK);
    }
}
