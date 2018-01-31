package com.ottodock.db;

import com.ottodock.core.User;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

@RegisterBeanMapper(User.class)

public interface UserDao {
    @SqlQuery("SELECT * FROM otto_user")
    List<User> listUsers();

}
