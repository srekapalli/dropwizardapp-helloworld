package com.example.helloworld.resources

import com.codahale.metrics.annotation.Timed
import com.google.common.base.Optional
import io.dropwizard.jersey.caching.CacheControl
import groovy.util.logging.Slf4j
import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicLong

@Path('/hello-world')
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class HelloWorldResource {

    private final AtomicLong counter

    public HelloWorldResource() {
        this.counter = new AtomicLong()
    }

    @GET
    @Timed(name = 'get-requests')
    @CacheControl(maxAge = 1, maxAgeUnit = TimeUnit.DAYS)
    public String sayHello(@QueryParam('name') Optional<String> name) {
        return name
    }

    @POST
    public void receiveHello(@Valid String name) {
        log.info("Received a saying: ${name}")
    }
}
