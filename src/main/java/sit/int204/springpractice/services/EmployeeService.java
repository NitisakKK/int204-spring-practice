package sit.int204.springpractice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import sit.int204.springpractice.entities.Employee;
import sit.int204.springpractice.repositories.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repository;

    public Page<Employee> findEmployeeWithLastnameAndJobByPage(String lastname, String jobTitle, int pageNo, int pageSize, String[] sortBy, String[] sortDirection) {
        List<Sort.Order> sortOrder = new ArrayList<>();
        if (sortBy.length != sortDirection.length)
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Sort value and direction value should have the same length.");
        for (int i = 0; i < sortBy.length; i++) {
            // adding sort order [(name, desc), (job, asc)]
            sortOrder.add(new Sort.Order((Sort.Direction.fromString(sortDirection[i])), sortBy[i]));
        }

        Pageable page = PageRequest.of(pageNo, pageSize, Sort.by(sortOrder));
        return repository.findEmployeeByLastNameContainsIgnoreCaseAndJobTitleContainingIgnoreCase(lastname, jobTitle, page);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }
}
