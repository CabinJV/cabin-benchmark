package com.cabin.demo;

import com.cabin.express.config.Environment;
import com.cabin.express.middleware.GzipMiddleware;
import com.cabin.express.server.CabinServer;
import com.cabin.express.server.ServerBuilder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CabinServer server = new ServerBuilder()
                .setMaxPoolSize(200)
                .setDefaultPoolSize(10)
                .setPort(8080)
                .build();

        server.use(new GzipMiddleware());
        server.use(new JsonRouter().create());

        server.start();
    }
}