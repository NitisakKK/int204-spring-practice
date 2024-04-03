package sit.int204.springpractice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sit.int204.springpractice.services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("")
    public ResponseEntity<Object> getAllProducts(@RequestParam(defaultValue = "false") boolean isPageable,
                                                 @RequestParam(defaultValue = "0") int pageNo,
                                                 @RequestParam(defaultValue = "0") int pageSize,
                                                 @RequestParam(defaultValue = "[]") String[] sortBy,
                                                 @RequestParam(defaultValue = "[]") String[] sortDirection) {
        if (isPageable) return ResponseEntity.ok(service.getAllProduct(pageNo,pageSize,sortBy,sortDirection));
        else return ResponseEntity.ok(service.getAllProduct());
    }
}
