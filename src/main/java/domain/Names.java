package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Names {
    Аарон, Абрам, Аваз, Августин, Авраам, Агап, Агапит, Агат, Агафон, Адам, Адриан, Азамат, Азат, Азиз, Аид, Айдар, Айрат, Акакий,
    Аким, Алан, Александр, Алексей, Али, Алик, Алим, Алихан, Алишер, Алмаз, Альберт, Амир, Амирам, Анар, Анастасий, Анатолий,
    Анвар, Ангел, Андрей, Анзор, Антон, Анфим, Арам, Аристарх, Аркадий, Арман, Армен, Арсен, Арсений, Арслан, Артём, Артемий,
    Артур, Архип, Аскар, Аслан, Асхан, Асхат, Ахмет, Ашот;

    private static final List<Names> values = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int size = values.size();
    private static final Random random = new Random();

    public static String randomName() {

        return values.get(random.nextInt(size)).toString();

    }
}
