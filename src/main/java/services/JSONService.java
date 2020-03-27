package services;

public interface JSONService<T> {

    String convert(T object);

    T convert(String jsonString);
}
