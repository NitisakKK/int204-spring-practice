package sit.int204.springpractice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.springpractice.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
