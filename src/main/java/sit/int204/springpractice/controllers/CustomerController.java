package sit.int204.springpractice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sit.int204.springpractice.entities.Customer;
import sit.int204.springpractice.exceptions.ItemNotFoundException;
import sit.int204.springpractice.models.MyError;
import sit.int204.springpractice.services.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    CustomerService service;

    @GetMapping("")
    public ResponseEntity<Object> getAllCustomers() {
        return ResponseEntity.ok(service.getAllCustomer());
    }
    @GetMapping("/{customerNumber}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int customerNumber) {
        return ResponseEntity.ok(service.getCustomerDtoById(customerNumber));
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<MyError> handleCustomerNotFound(Exception exception) {
        MyError error = new MyError(exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
