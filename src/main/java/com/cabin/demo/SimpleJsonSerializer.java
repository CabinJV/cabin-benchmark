package com.cabin.demo;

public class SimpleJsonSerializer {
    public static String toJson(Object obj) {
        if (obj instanceof JsonResponse) {
            JsonResponse response = (JsonResponse) obj;
            return String.format("{\"message\":\"%s\"}", response.getMessage());
        }

        throw new IllegalArgumentException("Unsupported object type for JSON serialization");
    }
}
