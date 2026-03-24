package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JsonFileSerializerTest {

    @JsonSerializable(directory = "target/test-output/")
    private static class TestPerson {
        private final String name = "Ana";
        private final String surname = "Lopez";
        private final int age = 30;
    }

    private static class NotAnnotated {
    }

    @Test
    void serialize_null_throws() {
        assertThatThrownBy(() -> JsonFileSerializer.serialize(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Target object cannot be null");
    }

    @Test
    void serialize_without_annotation_throws() {
        assertThatThrownBy(() -> JsonFileSerializer.serialize(new NotAnnotated()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("is not annotated");
    }

    @Test
    void serialize_writes_json() throws Exception {
        Path output = JsonFileSerializer.serialize(new TestPerson());
        assertThat(output).exists();
        String json = Files.readString(output, StandardCharsets.UTF_8);
        assertThat(json).contains("\"name\"").contains("\"surname\"").contains("\"age\"");
    }

    @Test
    void readAnnotation_prints_name_and_value() {
        PrintStream original = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer, true, StandardCharsets.UTF_8));
        try {
            JsonFileSerializer.readAnnotation(new TestPerson());
        } finally {
            System.setOut(original);
        }
        String out = buffer.toString(StandardCharsets.UTF_8);
        assertThat(out).contains("Annotation Name: JsonSerializable")
                .contains("value: target/test-output/");
    }

    @Test
    void readAnnotation_without_annotation_prints_message() {
        PrintStream original = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer, true, StandardCharsets.UTF_8));
        try {
            JsonFileSerializer.readAnnotation(new NotAnnotated());
        } finally {
            System.setOut(original);
        }
        assertThat(buffer.toString(StandardCharsets.UTF_8))
                .contains("No @JsonSerializable annotation found.");
    }
}
