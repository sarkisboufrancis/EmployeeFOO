package mobi.foo.Employee.Service;

import lombok.RequiredArgsConstructor;
import mobi.foo.Employee.DTO.EmployeeDTO;
import mobi.foo.Employee.Entity.Department;
import mobi.foo.Employee.Entity.Employee;
import mobi.foo.Employee.Repository.DepartmentRepository;
import mobi.foo.Employee.Response.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public ResponseEntity<Response> findAll() {
        List<Department> departments= departmentRepository.findAll();
        return new ResponseEntity<>(Response.builder().status(true).message("We have found all the Departments").data(departments).build(), HttpStatus.OK);
    }

    public ResponseEntity<Response> save (Department department){
        departmentRepository.save(department);
        return new ResponseEntity<>(Response.builder().status(true).message("created department  done").data(department).build(), HttpStatus.OK);

    }

}
