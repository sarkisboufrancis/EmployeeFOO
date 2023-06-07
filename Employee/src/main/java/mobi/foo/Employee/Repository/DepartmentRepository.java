package mobi.foo.Employee.Repository;

import mobi.foo.Employee.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
