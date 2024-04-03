package sit.int204.springpractice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicatedDataException extends ResponseStatusException {
    public DuplicatedDataException(String reason) {
        super(HttpStatus.BAD_REQUEST, reason);
    }
}
