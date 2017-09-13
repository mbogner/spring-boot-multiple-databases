package pm.mbo.spring.database.rest.io.request;

import lombok.Value;
import pm.mbo.spring.database.rest.io.DB;

@Value
public class CreateUserRequest {

    private final String name;

    private final DB db;

}
