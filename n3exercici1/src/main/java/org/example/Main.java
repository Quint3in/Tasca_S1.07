package org.example;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    static void main() {
        Person person = new Person("Maria", "Gomez", 28);
        readAnnotation(person);
        try {
            Path output = JsonFileSerializer.serialize(person);
            System.out.println("JSON written to: " + output.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to write JSON: " + e.getMessage());
        }
    }

    private static void readAnnotation(Object target) {
        Class<?> type = target.getClass();
        if (type.isAnnotationPresent(JsonSerializable.class)) {
            JsonSerializable annotation = type.getAnnotation(JsonSerializable.class);
            System.out.println("Annotation read via reflection. Directory: " + annotation.directory());
        } else {
            System.out.println("No @JsonSerializable annotation found.");
        }
    }
}
