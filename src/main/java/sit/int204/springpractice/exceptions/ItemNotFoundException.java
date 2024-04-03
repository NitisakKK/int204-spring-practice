package sit.int204.springpractice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends ResponseStatusException {

    public ItemNotFoundException(String reason) {
        super(HttpStatus.NOT_FOUND, reason);
    }
}
