package com.ottodock;

import com.ottodock.db.UserDao;
import com.ottodock.health.DbHealthCheck;
import com.ottodock.resources.UserResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.bundles.DBIExceptionsBundle;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.postgres.PostgresPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;


public class OttoDockApplication extends Application<OttoDockConfiguration> {

    public static void main(final String[] args) throws Exception {
        new OttoDockApplication().run(args);
    }

    @Override
    public String getName() {
        return "OttoDock";
    }

    @Override
    public void initialize(final Bootstrap<OttoDockConfiguration> bootstrap) {
        // TODO: application initialization
        bootstrap.addBundle(new DBIExceptionsBundle());
        bootstrap.addBundle(new AssetsBundle("/assets/", "/", "index.html"));

    }

    @Override
    public void run(final OttoDockConfiguration configuration,
                    final Environment environment) {

        final Jdbi jdbi = Jdbi.create(configuration.getDataSourceFactory().build(environment.metrics(),"dockDb"));
        jdbi.installPlugin(new PostgresPlugin());
        jdbi.installPlugin(new SqlObjectPlugin());
        final UserDao userDao = jdbi.onDemand(UserDao.class);

        final UserResource userResource = new UserResource(userDao);
        environment.jersey().register(userResource);

        final DbHealthCheck healthCheck =
                new DbHealthCheck(jdbi, "Select 1");
        environment.healthChecks().register("dockDb", healthCheck);

    }

}
