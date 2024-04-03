package sit.int204.springpractice.controllers;

import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sit.int204.springpractice.entities.Employee;
import sit.int204.springpractice.services.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @GetMapping("")
    public ResponseEntity<Object> getAllEmployees(
            @RequestParam(defaultValue = "", required = false) String lastname,
            @RequestParam(defaultValue = "", required = false) String jobTitle,
            @RequestParam(defaultValue = "false", required = false) boolean isPageable,
            @RequestParam(defaultValue = "0", required = false) int pageNo,
            @RequestParam(defaultValue = "10", required = false) int pageSize,
            @RequestParam(defaultValue = "[]", required = false) String[] sortBy,
            @RequestParam(defaultValue = "[]", required = false) String[] sortDirection
    ) {
        if (isPageable) {
            Page<Employee> employeePage = service.findEmployeeWithLastnameAndJobByPage(lastname, jobTitle, pageNo, pageSize, sortBy, sortDirection);
            return ResponseEntity.ok(employeePage);
        } else {
            return ResponseEntity.ok().body(service.getAllEmployees());
        }
    }


}
