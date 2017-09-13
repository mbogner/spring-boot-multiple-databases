package pm.mbo.spring.database.db2.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pm.mbo.spring.database.db2.entity.UserDb2;

import java.util.UUID;

public interface UserDb2Repository extends JpaRepository<UserDb2, UUID> {
}
