package sit.int204.springpractice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.springpractice.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findEmployeeByLastNameContainsIgnoreCaseAndJobTitleContainingIgnoreCase(String lastName, String job, Pageable pageable);
}
