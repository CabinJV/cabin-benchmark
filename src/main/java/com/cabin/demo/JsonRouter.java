package com.cabin.demo;

import com.cabin.express.http.Request;
import com.cabin.express.http.Response;
import com.cabin.express.router.Router;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class JsonRouter {
    public Router create() {
        Router router = new Router();
        router.get("/json", this::hello);
        return router;
    }

    private void hello(Request req, Response resp) {
        JsonResponse jsonResponse = new JsonResponse("Hello, World!");
        String jsonString = SimpleJsonSerializer.toJson(jsonResponse);
        byte[] jsonBytes = jsonString.getBytes();

        resp.setHeader("Content-Type", "application/json");
        resp.setHeader("Server", "CabinJ/26.0.0");
        resp.setHeader("Date", ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME));
        resp.setHeader("Connection", "keep-alive");

        resp.send(jsonString);
    }
}
