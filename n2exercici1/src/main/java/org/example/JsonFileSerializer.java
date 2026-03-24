package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public final class JsonFileSerializer {
    private static final ObjectMapper MAPPER = buildMapper();

    private JsonFileSerializer() {
    }

    public static Path serialize(Object target) {
        if (target == null) {
            throw new IllegalArgumentException("Target object cannot be null.");
        }
        Class<?> type = target.getClass();
        JsonSerializable annotation = getJsonSerializable(type);
        Path directory = Paths.get(annotation.directory());
        ensureDirectory(directory);
        Path outputFile = directory.resolve(type.getSimpleName() + ".json");
        writeJsonToFile(outputFile, target);
        return outputFile;
    }

    private static JsonSerializable getJsonSerializable(Class<?> type) {
        JsonSerializable annotation = type.getAnnotation(JsonSerializable.class);
        if (annotation == null) {
            throw new IllegalArgumentException("Class " + type.getSimpleName() + " is not annotated with @JsonSerializable.");
        }
        return annotation;
    }

    private static void ensureDirectory(Path directory) {
        try {
            Files.createDirectories(directory);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void writeJsonToFile(Path outputFile, Object target) {
        String json = toJson(target);
        try {
            Files.writeString(outputFile, json, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static String toJson(Object target) {
        try {
            return MAPPER.writeValueAsString(target);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to serialize object to JSON.", e);
        }
    }

    private static ObjectMapper buildMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        return mapper;
    }
}
