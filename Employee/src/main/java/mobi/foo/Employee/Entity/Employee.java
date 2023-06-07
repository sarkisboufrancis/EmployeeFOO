package mobi.foo.Employee.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import mobi.foo.Employee.Entity.Department;



@Data
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;


    @Column(nullable = false)
    @Size(min=2,max=15,message="this must be between 2 and 15 characters")
    private String firstName;


    @Column(nullable = false)
    @Size(min=2,max=15,message="this must be between 2 and 15 characters")
    private String lastName;

    @Column(nullable = false)
    @Size(min=2,max=15,message="this must be between 2 and 10 characters")
    private String email;

    @ManyToOne
    @NotNull
    private  Department department;


}
