package sit.int204.springpractice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sit.int204.springpractice.dto.CustomerDto;
import sit.int204.springpractice.entities.Customer;
import sit.int204.springpractice.repositories.CustomerRepository;
import sit.int204.springpractice.utils.ListMapper;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository repository;
    @Autowired
    ListMapper listMapper;

    public List<Customer> getAllCustomer() {
        return listMapper.mapList(repository.findAll(), CustomerDto.class);
    }

//    public List<Customer> getAllCustomer() {
//        return repository.findAll();
//    }
}
