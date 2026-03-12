package org.example;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public final class JsonFileSerializer {
    private JsonFileSerializer() {
    }

    public static Path serialize(Object target) throws IOException {
        if (target == null) {
            throw new IllegalArgumentException("Target object cannot be null.");
        }

        Class<?> type = target.getClass();
        JsonSerializable annotation = type.getAnnotation(JsonSerializable.class);
        if (annotation == null) {
            throw new IllegalArgumentException("Class " + type.getSimpleName() + " is not annotated with @JsonSerializable.");
        }

        Path directory = Paths.get(annotation.directory());
        Files.createDirectories(directory);

        String json = toJson(target);
        Path outputFile = directory.resolve(type.getSimpleName() + ".json");
        Files.writeString(outputFile, json, StandardCharsets.UTF_8);
        return outputFile;
    }

    private static String toJson(Object target) {
        List<String> fields = new ArrayList<>();
        for (Field field : target.getClass().getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            field.setAccessible(true);
            Object value;
            try {
                value = field.get(target);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Unable to access field: " + field.getName(), e);
            }
            fields.add("\"" + escape(field.getName()) + "\":" + formatValue(value));
        }
        return "{\n  " + String.join(",\n  ", fields) + "\n}";
    }

    private static String formatValue(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof Number || value instanceof Boolean) {
            return value.toString();
        }
        return "\"" + escape(value.toString()) + "\"";
    }

    private static String escape(String input) {
        return input
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }
}
