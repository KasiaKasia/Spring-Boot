package com.example.demo.person.mapper;

import com.example.demo.person.dto.CreateOrUpdatePersonDTO;
import com.example.demo.person.dto.PersonDTO;
import com.example.demo.person.model.Person;
import org.springframework.stereotype.Component;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonMapper {

    public PersonDTO mapToDTO(Person person) {
        var personDTO = new PersonDTO();
        personDTO.setId(person.getId());
        personDTO.setFirstName(person.getFirstName());
        personDTO.setLastName(person.getLastName());
        return personDTO;
    }

    public List<PersonDTO> mapToDTO(Collection<Person> persons) {
        return persons.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Person mapTo(CreateOrUpdatePersonDTO newPerson) {
        var person = new Person();
        person.setFirstName(newPerson.getFirstName());
        person.setLastName(newPerson.getLastName());
        return person;
    }

    public Person mapTo(Person person, CreateOrUpdatePersonDTO newPerson) {
        person.setFirstName(newPerson.getFirstName());
        person.setLastName(newPerson.getLastName());
        return person;
    }
}
