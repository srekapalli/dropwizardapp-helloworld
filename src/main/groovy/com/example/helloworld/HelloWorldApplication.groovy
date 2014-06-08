package com.example.helloworld

import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import io.dropwizard.db.DataSourceFactory
import io.dropwizard.hibernate.HibernateBundle
import io.dropwizard.migrations.MigrationsBundle
import groovy.util.logging.Slf4j
import com.example.helloworld.db.*
import com.example.helloworld.resources.*

@Slf4j
class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    private final String name = 'HelloWorld'

    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args)
    }

    @Override
    public void run(HelloWorldConfiguration configuration,
                    Environment environment) throws ClassNotFoundException {
        log.debug("Running ${name}..")
        environment.jersey().register(new HelloWorldResource())
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        bootstrap.with {
            addBundle migrationsBundle
            addBundle hibernateBundle
        }
    }

    private final HibernateBundle<HelloWorldConfiguration> hibernateBundle =
       new HibernateBundle<HelloWorldConfiguration>(Person, Person) {
            @Override
            public DataSourceFactory getDataSourceFactory(HelloWorldConfiguration configuration) {
                return configuration.database
            }
        }

    private final MigrationsBundle<HelloWorldConfiguration> migrationsBundle =
        new MigrationsBundle<HelloWorldConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(HelloWorldConfiguration configuration) {
                return configuration.database
            }
        }

}
