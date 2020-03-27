package test.services;

import domain.Person;
import org.junit.Test;
import util.PersonGenerateService;

import java.util.List;

import static org.junit.Assert.assertFalse;

public class TestPersonGenerationService {

    private PersonGenerateService personGenerateService = new PersonGenerateService();

    @Test
    public void testGenerateRandomPeople() {

        List<Person> people = personGenerateService.generateRandomPeople();

        assertFalse(people.isEmpty());
        assertFalse(people.get(0).getName().isEmpty());
        assertFalse(people.get(0).getAge() < 0);
        assertFalse(people.get(0).getId() < 0);

    }

}
