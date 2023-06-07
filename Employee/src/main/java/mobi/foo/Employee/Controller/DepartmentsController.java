package mobi.foo.Employee.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mobi.foo.Employee.Entity.Department;
import mobi.foo.Employee.Entity.Employee;
import mobi.foo.Employee.Response.Response;
import mobi.foo.Employee.Service.DepartmentService;
import mobi.foo.Employee.Service.EmployeeService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Api/v1/Departments")
@RequiredArgsConstructor
public class DepartmentsController {
    private  final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<Response> getAllDepartments(){
        return departmentService.findAll();
    }

    @PostMapping("/addDepartment")
    public ResponseEntity<Response> createEmployee(@RequestBody @Valid Department department){
        return departmentService.save(department);
    }
}
