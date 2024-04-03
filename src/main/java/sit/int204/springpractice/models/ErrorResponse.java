package sit.int204.springpractice.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class ErrorResponse {
    private final String title;
    private final int status;
    private final String message;
    private final String instance;
    private String stackTrace;
    private final LocalDateTime timeStamp = LocalDateTime.now();
}
