package mobi.foo.Employee.Service;

import lombok.RequiredArgsConstructor;
import mobi.foo.Employee.DTO.EmployeeDTO;
import mobi.foo.Employee.Entity.Employee;
import mobi.foo.Employee.Repository.DepartmentRepository;
import mobi.foo.Employee.Repository.EmployeeRepository;
import mobi.foo.Employee.Response.Response;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;
    private final DepartmentRepository departmentRepository;

    public ResponseEntity<Response> findAll(Pageable pageable) {
        Page<Employee> employeePage = employeeRepository.findAll(pageable);
        List<EmployeeDTO> employees= employeePage.getContent().stream().map(emp -> modelMapper.map(emp, EmployeeDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(Response.builder().status(true).message("We have found all the employee").data(employees).build(), HttpStatus.OK);
    }

    public ResponseEntity<Response> save (Employee employee){
         employeeRepository.save(employee);
        return new ResponseEntity<>(Response.builder().status(true).message("created done").data(modelMapper.map(employee,EmployeeDTO.class)).build(), HttpStatus.OK);

    }

    public  ResponseEntity<Response> findById(Long id) {
        Optional<EmployeeDTO> employee =employeeRepository.findById(id).map(employ ->modelMapper.map(employ,EmployeeDTO.class) );
        return new ResponseEntity<>(Response.builder().status(true).message("searching an employee by id").data(employee).build(), HttpStatus.OK);
    }

    public ResponseEntity<Response>  deleteById(Long id) {
        employeeRepository.deleteById(id);
        return new ResponseEntity<>(Response.builder().status(true).message("We have deleted the employee").data("").build(), HttpStatus.OK);
    }
    public ResponseEntity<Response> AllEmployeesSortedByFirstName(boolean ascending) {
        Sort.Direction direction = ascending ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, "firstName");
        List<Employee> EmployeesSortedByFirstName = employeeRepository.findAll(sort);
        return new ResponseEntity<>(Response.builder().status(true).message("Sorted by First Name").data(EmployeesSortedByFirstName).build(), HttpStatus.OK);
    }

    public ResponseEntity<Response> AllEmployeesSortedByLastName(boolean ascending) {
        Sort.Direction direction = ascending ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, "lastName");
        List<Employee> EmployeesSortedByLastName= employeeRepository.findAll(sort);
        return new ResponseEntity<>(Response.builder().status(true).message("Sorted by Last Name").data(EmployeesSortedByLastName).build(), HttpStatus.OK);
    }

    public ResponseEntity<Response> searchEmployeesByName(String keyword) {
        Employee employee = new Employee();
        employee.setFirstName(keyword);
        employee.setLastName(keyword);

        ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withMatcher("firstName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("lastName", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        Example<Employee> example = Example.of(employee, matcher);

       List<Employee> employees= employeeRepository.findAll(example);
        return new ResponseEntity<>(Response.builder().status(true).message("find employee by name").data(employees).build(), HttpStatus.OK);
    }
}

