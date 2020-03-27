package services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import services.JSONService;

@RequiredArgsConstructor
@Slf4j
public class LogSerializeTimeDecorator<T> implements JSONService<T> {

    private final JSONService<T> service;

    @Override
    public String convert(T object) {

        long time = System.currentTimeMillis();
        String jsonString = service.convert(object);
        time = System.currentTimeMillis() - time;
        log.info(time + " milliseconds");

        return jsonString;

    }

    @Override
    public T convert(String jsonString) {

        long time = System.currentTimeMillis();
        T object = service.convert(jsonString);
        time = System.currentTimeMillis() - time;
        log.info(time + " milliseconds");

        return object;

    }
}
