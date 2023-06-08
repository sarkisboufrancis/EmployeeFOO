package mobi.foo.Employee.Controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mobi.foo.Employee.DTO.EmployeeDTO;
import mobi.foo.Employee.Entity.Employee;
import mobi.foo.Employee.Response.Response;
import mobi.foo.Employee.Service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/Api/v1/Employee")
@RequiredArgsConstructor
public class EmployeeController {

    private  final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<Response> getAllEmployee( Pageable pageable){
        return employeeService.findAll(pageable);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Response> createEmployee(@RequestBody  @Valid  Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getProductById(@PathVariable("id") Long id) {
        return employeeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteProduct(@PathVariable("id") Long id) {
        return  employeeService.deleteById(id);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Response> updateEmployee(@PathVariable("id")  Long id, @RequestBody @Valid Employee employee){
        employee.setId(id);
        return employeeService.save(employee);

    }
    @GetMapping("/sorted-by-firstname")
    public ResponseEntity<Response> getAllEmployeesSortedByFirstName(@RequestParam(defaultValue = "true") boolean ascending) {
        return employeeService.AllEmployeesSortedByFirstName(ascending);
    }

    @GetMapping("/sorted-by-lastname")
    public ResponseEntity<Response> getAllEmployeesSortedByLastName(@RequestParam(defaultValue = "true") boolean ascending) {
        return employeeService.AllEmployeesSortedByLastName(ascending);
    }
    @GetMapping("/search")
    public ResponseEntity<Response> searchEmployeesByName(@RequestParam String keyword) {
        return employeeService.searchEmployeesByName(keyword);
    }
    @GetMapping(value="/searchDepartment")
    public ResponseEntity<Response> searchByDepartment(@RequestParam(defaultValue = "") String Name){
        return employeeService.searchByDepartment(Name);
    }
}
