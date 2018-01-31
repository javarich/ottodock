package com.ottodock.health;

import com.codahale.metrics.health.HealthCheck;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

public class DbHealthCheck extends HealthCheck {
        private final Jdbi jdbi;
        private final String validationQuery;

        public DbHealthCheck(Jdbi jdbi, String validationQuery) {
            this.jdbi = jdbi;
            this.validationQuery = validationQuery;
        }

        @Override
        protected Result check() throws Exception {
            try (Handle handle = jdbi.open()) {
                handle.execute(validationQuery);
            }
            return Result.healthy();
        }

    }
