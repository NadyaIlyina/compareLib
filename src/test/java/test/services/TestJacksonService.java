package test.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import org.junit.Test;
import services.impl.JacksonService;

import static org.junit.Assert.assertTrue;

public class TestJacksonService {

    private final JacksonService<Person> service = new JacksonService<>();
    private final Person person = new Person();
    @Test
    public void validJSON()  {

        final ObjectMapper mapper = new ObjectMapper();

        boolean valid =true;
        try {
            mapper.readTree(service.convert(person));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            valid =false;
        }
        assertTrue(valid);
    }

}
