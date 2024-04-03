package sit.int204.springpractice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int204.springpractice.entities.Customer;
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
//    @GetMapping("/{customerNumber}")
//    public ResponseEntity<Customer> getCustomerById(@PathVariable int customerNumber) {
//        return
//    }
}
