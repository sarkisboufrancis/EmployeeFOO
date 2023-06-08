package mobi.foo.Employee.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@Entity
@Data
@EntityScan
@Table(name = "Department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    @Size(min=2,max=15,message="this must be between 2 and 15 characters")
    private String name;

}
