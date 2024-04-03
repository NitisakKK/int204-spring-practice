package sit.int204.springpractice.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import sit.int204.springpractice.dto.EmployeeDto;
import sit.int204.springpractice.dto.NewEmployeeDto;
import sit.int204.springpractice.entities.Employee;
import sit.int204.springpractice.entities.Office;
import sit.int204.springpractice.exceptions.DuplicatedDataException;
import sit.int204.springpractice.exceptions.ItemNotFoundException;
import sit.int204.springpractice.repositories.EmployeeRepository;
import sit.int204.springpractice.repositories.OfficeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repository;
    @Autowired
    OfficeService officeService;
    @Autowired
    ModelMapper modelMapper;

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

    public Employee getEmployeeById(int id) {
        return repository.findById(id).orElseThrow(() -> new ItemNotFoundException("Can not find id " + id));
    }

    public EmployeeDto getEmployeeByIdDto(int id) {
        Employee emp =  repository.findById(id).orElseThrow(() -> new ItemNotFoundException("Can not find id " + id));
        System.out.println("Convert DTO");
        EmployeeDto employeeDto = modelMapper.map(emp, EmployeeDto.class);
        return employeeDto;

    }

    @Transactional
    public EmployeeDto addNewEmployeeDto(NewEmployeeDto newEmployeeDto) {
        if (newEmployeeDto==null) throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, " new Employee is null");
        if (repository.existsById(newEmployeeDto.getId())) throw new DuplicatedDataException(" newEmployeeDto id is already exists.");

        Employee employeeMap = modelMapper.map(newEmployeeDto, Employee.class);
        employeeMap.setOffice(officeService.getOfficeById(newEmployeeDto.getOfficeId()));
        employeeMap.setReportsTo(this.getEmployeeById(newEmployeeDto.getReportsTo()));

        return modelMapper.map(repository.saveAndFlush(employeeMap), EmployeeDto.class);
    }

    @Transactional
    public Employee updateEmployee(NewEmployeeDto updateEmployeeDto) {
        if (updateEmployeeDto==null) throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, " new Employee is null");
        if (!repository.existsById(updateEmployeeDto.getId())) throw new ItemNotFoundException(" can not found employee id " + updateEmployeeDto.getId());

        Employee employeeMap = modelMapper.map(updateEmployeeDto, Employee.class);
        employeeMap.setOffice(officeService.getOfficeById(updateEmployeeDto.getOfficeId()));
        employeeMap.setReportsTo(this.getEmployeeById(updateEmployeeDto.getReportsTo()));
        return employeeMap;
    }
}
