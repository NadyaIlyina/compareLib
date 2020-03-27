package test.services;

import com.google.gson.Gson;
import domain.Person;
import org.junit.Test;
import services.impl.GSONService;

import static org.junit.Assert.assertTrue;

public class TestGSONService {

    private static final Gson gson = new Gson();

    @Test
    public void validJSON()  {
        GSONService<Person> service = new GSONService<>();
        boolean valid =true;
        try {
            gson.fromJson(service.convert(new Person()), Object.class);
        } catch (com.google.gson.JsonSyntaxException e) {
            e.printStackTrace();
            valid =false;
        }
        assertTrue(valid);

    }
}
