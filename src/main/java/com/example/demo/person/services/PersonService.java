package com.example.demo.person.services;

import com.example.demo.person.dto.CreateOrUpdatePersonDTO;
import com.example.demo.person.dto.PersonDTO;
import java.util.List;

public interface PersonService {
    List<PersonDTO> findAll();
    PersonDTO findById(Integer id);
    PersonDTO save(CreateOrUpdatePersonDTO newPerson);
    PersonDTO update(Integer id, CreateOrUpdatePersonDTO person);
}
