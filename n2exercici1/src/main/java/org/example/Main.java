package org.example;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    static void main() {
        Person person = new Person("Maria", "Gomez", 28);
        try {
            Path output = JsonFileSerializer.serialize(person);
            System.out.println("JSON written to: " + output.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("Failed to write JSON: " + e.getMessage());
        }
    }
}
