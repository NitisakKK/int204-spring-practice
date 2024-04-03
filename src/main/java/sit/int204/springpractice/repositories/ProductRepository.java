package sit.int204.springpractice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.springpractice.entities.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
}
