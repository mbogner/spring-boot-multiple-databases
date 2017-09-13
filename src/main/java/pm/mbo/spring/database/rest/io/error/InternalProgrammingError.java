package pm.mbo.spring.database.rest.io.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "this indicates an internal coding error - please report this")
public class InternalProgrammingError extends RuntimeException {

    public InternalProgrammingError() {
        super();
    }

}
