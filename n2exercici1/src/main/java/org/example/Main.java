package org.example;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Maria", "Gomez", 28);
            Path output = JsonFileSerializer.serialize(person);
            System.out.println("JSON written to: " + output.toAbsolutePath());
    }
}
