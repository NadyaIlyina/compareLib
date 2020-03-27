package services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import services.JSONService;

@Slf4j
public class JacksonService<T> implements JSONService<T> {

    private final ObjectMapper mapper = new ObjectMapper();

    private final TypeReference<T> serializeTypeJackson = new TypeReference<T>() {};

    @Override
    public String convert(T object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.warn("List of objects can't be serialize to json");
        }
        return null;
    }

    @Override
    public T convert(String jsonString) {
        try {
            return mapper.readValue(jsonString, serializeTypeJackson);

        } catch (JsonProcessingException e) {
            log.warn("String can't be serialize to list of objects");
        }
        return null;
    }
}
