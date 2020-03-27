import domain.Person;
import lombok.extern.slf4j.Slf4j;
import services.JSONService;
import services.impl.GSONService;
import services.impl.JacksonService;
import services.impl.LogSerializeTimeDecorator;
import util.PersonGenerateService;

import java.util.List;

@Slf4j
public class Main {

    private static PersonGenerateService service = new PersonGenerateService();

    public static void main(String[] args) {
        List<Person> people = service.generateRandomPeople();

        log.info("GSON library: ");
        logTimeOfWork(new GSONService<List<Person>>(), people);
        log.info("Jackson library: ");
        logTimeOfWork(new JacksonService<List<Person>>(), people);

    }

    public static <T> void logTimeOfWork(JSONService<T> service, T object) {

        LogSerializeTimeDecorator<T> srv = new LogSerializeTimeDecorator<>(service);
        log.info("To JSON: ");
        String str = srv.convert(object);
        log.info("From JSON: ");
        T tList = srv.convert(str);

    }
}
