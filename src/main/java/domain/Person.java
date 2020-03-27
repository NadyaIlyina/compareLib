package domain;

import lombok.Data;
import uk.co.jemos.podam.annotations.PodamIntValue;

@Data
public class Person {

    @PodamIntValue(minValue = 0, maxValue = 100)
    private int id;
    private String name;
    @PodamIntValue(minValue = 0, maxValue = 100)
    private int age;

    @Override
    public String toString() {

        return "Id: " + id + "\nName: " + name + "\nAge: " + age + "\n";

    }
}
