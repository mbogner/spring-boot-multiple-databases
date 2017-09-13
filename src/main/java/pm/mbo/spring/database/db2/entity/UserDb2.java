package pm.mbo.spring.database.db2.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "users_db2")
public class UserDb2 {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @NotBlank
    @Column(nullable = false)
    private String name;
}
