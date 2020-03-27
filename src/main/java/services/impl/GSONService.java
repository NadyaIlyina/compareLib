package services.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import services.JSONService;

import java.lang.reflect.Type;

public class GSONService<T> implements JSONService<T> {

    private final Type serializeTypeGson = new TypeToken<T>() {}.getType();

    private final Gson gson = new Gson();

    @Override
    public T convert(String jsonString) {
        return gson.fromJson(jsonString, serializeTypeGson);
    }

    @Override
    public String convert(T object) {
        return gson.toJson(object);
    }
}
