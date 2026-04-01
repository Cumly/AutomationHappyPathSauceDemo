package org.example.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.User;

import java.io.File;
import java.util.List;

public class JsonUtils {

    public static <T> List<T> readJsonList(String path, TypeReference<List<T>> typeReference) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(path), typeReference);
        } catch (Exception e) {
            throw new RuntimeException("Error fatal leyendo el JSON en la ruta: " + path, e);
        }
    }
}