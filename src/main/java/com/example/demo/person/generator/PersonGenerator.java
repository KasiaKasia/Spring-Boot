package com.example.demo.person.generator;

import com.example.demo.person.dto.CreateOrUpdatePersonDTO;
import java.util.List;
import java.util.Random;

public class PersonGenerator {

    public PersonGenerator() {}

    private static final List<String> firstNames = List.of(
            "John", "Lonia", "Nikola", "Jonathan", "Kimberly", "Alicia", "Kelly", "Sarah"
    );

    private static final List<String> lastNames = List.of(
            "Kolonko", "Obama", "Nixon"
    );
    private static final Random generator = new Random();

    public static CreateOrUpdatePersonDTO generate() {
        int firstNameRandomIndex = generator.nextInt(firstNames.size());
        String firstName = firstNames.get(firstNameRandomIndex);

        int lastNameRandomIndex = generator.nextInt(lastNames.size());
        String lastName = lastNames.get(lastNameRandomIndex);

        return new CreateOrUpdatePersonDTO(firstName, lastName);
    }
}
