package com.ottodock.resources;

import com.codahale.metrics.annotation.Timed;
import com.ottodock.core.User;
import com.ottodock.db.UserDao;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/users")
//@Produces(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
public class UserResource {

    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());
    private final UserDao userDao;

    public UserResource(UserDao userDao) {
        this.userDao = userDao;
    }

    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers(@QueryParam("name") Optional<String> name) {
        log.info("Sample page query string = {}", name);
        return userDao.listUsers();
    }

    @GET
    @Path("/hello")
    public String hello() {
        return "Hello";
    }

}
