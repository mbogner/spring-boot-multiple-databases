package pm.mbo.spring.database.mongo2.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import pm.mbo.spring.database.mongo2.entity.UserMongo2;

import java.util.UUID;

public interface UserMongo2Repository extends MongoRepository<UserMongo2, UUID> {
}
