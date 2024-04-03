package sit.int204.springpractice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.springpractice.entities.Office;
import sit.int204.springpractice.exceptions.ItemNotFoundException;
import sit.int204.springpractice.repositories.OfficeRepository;

@Service
public class OfficeService {
    @Autowired
    OfficeRepository repository;

    public Office getOfficeById(String id) {
        return repository.findById(id).orElseThrow(() -> new ItemNotFoundException("Can not find id " + id));
    }
}
