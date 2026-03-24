package org.example;

import java.nio.file.Path;

import static org.example.JsonFileSerializer.readAnnotation;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Maria", "Gomez", 28);
        readAnnotation(person);
        Path output = JsonFileSerializer.serialize(person);
           System.out.println("JSON written to: " + output.toAbsolutePath());
    }
}
