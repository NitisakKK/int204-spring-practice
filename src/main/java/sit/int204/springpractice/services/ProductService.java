package sit.int204.springpractice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import sit.int204.springpractice.entities.Product;
import sit.int204.springpractice.repositories.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;

    public List<Product> getAllProduct() {
        return repository.findAll();
    }

    public Page<Product> getAllProduct(int pageNo, int pageSize, String[] sortBy, String[] sortDirection) {
        List<Sort.Order> sortOrder = new ArrayList<>();
        if (sortBy.length != 0 || sortDirection.length != 0) {
            if (sortBy.length != sortDirection.length)
                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Sort value and direction value should have the same length.");
            for (int i = 0; i < sortBy.length; i++) {
                // adding sort order [(name, desc), (job, asc)]
                sortOrder.add(new Sort.Order((Sort.Direction.fromString(sortDirection[i])), sortBy[i]));
            }

            Pageable page = PageRequest.of(pageNo, pageSize, Sort.by(sortOrder));
            return repository.findAll(page);
        } else {
            Pageable page = PageRequest.of(pageNo, pageSize);
            return repository.findAll(page);
        }
    }
}
