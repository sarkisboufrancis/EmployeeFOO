package mobi.foo.Employee.DTO;
import lombok.Data;
import mobi.foo.Employee.Entity.Department;
@Data
public class EmployeeDTO {

    private Long Id;

    private String firstName;

    private String lastName;

    private String email;

    private Department department;
}
