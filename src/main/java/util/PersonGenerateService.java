package util;

import domain.Names;
import lombok.extern.slf4j.Slf4j;
import domain.Person;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PersonGenerateService {

    private final PodamFactory factory = new PodamFactoryImpl();

    private final ReadPropertyService readPropertyService = new ReadPropertyService();

    public List<Person> generateRandomPeople() {

        List<Person> people = new ArrayList<>();

        int n = readPropertyService.readProperty("people");
        for (int i = 0; i < n; i++) {
            Person person = factory.manufacturePojo(Person.class);
            person.setName(Names.randomName());
            people.add(person);
        }

        return people;

    }

}

