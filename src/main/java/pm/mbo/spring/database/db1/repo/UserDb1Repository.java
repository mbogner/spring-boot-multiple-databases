package pm.mbo.spring.database.db1.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pm.mbo.spring.database.db1.entity.UserDb1;

import java.util.UUID;

public interface UserDb1Repository extends JpaRepository<UserDb1, UUID> {
}
