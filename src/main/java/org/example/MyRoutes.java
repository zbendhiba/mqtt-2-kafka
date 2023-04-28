package org.example;

import org.apache.camel.builder.RouteBuilder;

public class MyRoutes extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("paho:queue-test")
                .log("received-message ${body}")
                .to("kafka:topic-test");
    }
}
