package sit.int204.springpractice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import sit.int204.springpractice.controllers.EmployeeController;
import sit.int204.springpractice.models.ErrorResponse;
import sit.int204.springpractice.repositories.EmployeeRepository;

@ControllerAdvice(assignableTypes = {EmployeeController.class})
public class GlobalExceptionHandler {

    public ResponseEntity<ErrorResponse> buildErrorResponse(String title, int statusCode, String message, String instance){
        ErrorResponse errorResponse = new ErrorResponse(title, statusCode, message, instance);
        return ResponseEntity.status(statusCode).body(errorResponse);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> handleItemNotFound(Exception exception, WebRequest request) {
        return buildErrorResponse("Item Not Found!!!", HttpStatus.NOT_FOUND.value(), exception.getMessage(), request.getDescription(false));
    }
}
