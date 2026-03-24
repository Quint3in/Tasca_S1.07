package org.example;

import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public final class JsonFileSerializerTest {

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
}
