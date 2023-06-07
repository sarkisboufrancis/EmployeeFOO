package mobi.foo.Employee.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Entity
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;



    @Size(min=2,max=15,message="this must be between 2 and 15 characters")
    private String Name;

}
