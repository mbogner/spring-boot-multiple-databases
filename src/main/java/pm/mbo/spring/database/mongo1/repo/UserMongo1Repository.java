package pm.mbo.spring.database.mongo1.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import pm.mbo.spring.database.mongo1.entity.UserMongo1;

import java.util.UUID;

public interface UserMongo1Repository extends MongoRepository<UserMongo1, UUID> {
}
