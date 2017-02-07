package com.guilherme.miguel.endpoint;

import com.guilherme.miguel.endpoint.helloworld.Greeting;
import com.guilherme.miguel.endpoint.helloworld.ObjectFactory;
import com.guilherme.miguel.endpoint.helloworld.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * @author Miguel Guilherme
 */
@Endpoint
public class HelloWorldEndpoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldEndpoint.class);

    private static final String NAMESPACE_URI = "http://localhost:8080/soap-api/helloworld";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "person")
    @ResponsePayload
    public Greeting sayHello(@RequestPayload Person request) {

        LOGGER.info("Endpoint received person=[firstName:{},lastName:{}]", request.getFirstName(), request.getLastName());

        String greeting = "Hello " + request.getFirstName() + " " + request.getLastName() + "!";

        ObjectFactory factory = new ObjectFactory();
        Greeting response = factory.createGreeting();
        response.setGreeting(greeting);

        LOGGER.info("Endpoint sending greeting='{}'", response.getGreeting());
        return response;
    }
}
