package sit.int204.springpractice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.springpractice.entities.Office;

public interface OfficeRepository extends JpaRepository<Office, String> {
}
