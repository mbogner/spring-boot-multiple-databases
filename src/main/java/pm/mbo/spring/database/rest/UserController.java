package pm.mbo.spring.database.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pm.mbo.spring.database.db1.entity.UserDb1;
import pm.mbo.spring.database.db1.repo.UserDb1Repository;
import pm.mbo.spring.database.db2.entity.UserDb2;
import pm.mbo.spring.database.db2.repo.UserDb2Repository;
import pm.mbo.spring.database.mongo1.entity.UserMongo1;
import pm.mbo.spring.database.mongo1.repo.UserMongo1Repository;
import pm.mbo.spring.database.mongo2.entity.UserMongo2;
import pm.mbo.spring.database.mongo2.repo.UserMongo2Repository;
import pm.mbo.spring.database.rest.io.error.InternalProgrammingError;
import pm.mbo.spring.database.rest.io.request.CreateUserRequest;
import pm.mbo.spring.database.rest.io.response.IdResponse;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserDb1Repository userDb1Repository;

    @Autowired
    private UserDb2Repository userDb2Repository;

    @Autowired
    private UserMongo1Repository userMongo1Repository;

    @Autowired
    private UserMongo2Repository userMongo2Repository;

    @RequestMapping(method = RequestMethod.GET, path = "/db1",
            produces = {
                    MediaType.APPLICATION_JSON_UTF8_VALUE
            })
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Page<UserDb1> getAllUsersDb1(@RequestHeader final HttpHeaders headers, final Pageable pageable) {
        return userDb1Repository.findAll(pageable);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/db2",
            produces = {
                    MediaType.APPLICATION_JSON_UTF8_VALUE
            })
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Page<UserDb2> getAllUsersDb2(@RequestHeader final HttpHeaders headers, final Pageable pageable) {
        return userDb2Repository.findAll(pageable);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/mongo1",
            produces = {
                    MediaType.APPLICATION_JSON_UTF8_VALUE
            })
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Page<UserMongo1> getAllUsersMongo1(@RequestHeader final HttpHeaders headers, final Pageable pageable) {
        return userMongo1Repository.findAll(pageable);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/mongo2",
            produces = {
                    MediaType.APPLICATION_JSON_UTF8_VALUE
            })
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Page<UserMongo2> getAllUsersMongo2(@RequestHeader final HttpHeaders headers, final Pageable pageable) {
        return userMongo2Repository.findAll(pageable);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.POST,
            produces = {
                    MediaType.APPLICATION_JSON_UTF8_VALUE
            },
            consumes = {
                    MediaType.APPLICATION_JSON_UTF8_VALUE
            })
    @ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    public IdResponse createUser(@RequestHeader final HttpHeaders headers, @RequestBody @Valid final CreateUserRequest request) {
        final String id;
        switch (request.getDb()) {
            case DB1:
                UserDb1 user1 = new UserDb1();
                user1.setName(request.getName());
                user1 = userDb1Repository.save(user1);
                id = user1.getId();
                break;
            case DB2:
                UserDb2 user2 = new UserDb2();
                user2.setName(request.getName());
                user2 = userDb2Repository.save(user2);
                id = user2.getId();
                break;
            // DB3 skipped intentionally to be able to call default
            case MONGO1:
                UserMongo1 userMongo1 = new UserMongo1();
                userMongo1.setName(request.getName());
                userMongo1 = userMongo1Repository.save(userMongo1);
                id = userMongo1.getId();
                break;
            case MONGO2:
                UserMongo2 userMongo2 = new UserMongo2();
                userMongo2.setName(request.getName());
                userMongo2 = userMongo2Repository.save(userMongo2);
                id = userMongo2.getId();
                break;
            default:
                throw new InternalProgrammingError();
        }
        return new IdResponse(id);
    }

}
