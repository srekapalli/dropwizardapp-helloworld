# Introduction

* This application uses dropwizard **0.7.0** version.  
* The application will start and will have sample resource impl, that you can hit to verify the application.
* For more detailed documentation refer to [DropWizard documentation](http://dropwizard.github.io/dropwizard/getting-started.html).
* This application is configured to use hibernate for database access, liquibase for migrations.

# Running The Application

To test the example application run the following commands.

* To run the tests run

`gradle test`

* To package the example run.

        gradle shadowJar

* To drop an existing h2 database run.

        gradle dropAll

* To setup the h2 database run.

        gradle migrate

* To run the server run.

        gradle run
