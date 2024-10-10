package com.example.demo.person.services;

import com.example.demo.person.dto.CreateOrUpdatePersonDTO;
import com.example.demo.person.dto.PersonDTO;
import com.example.demo.person.mapper.PersonMapper;
import com.example.demo.person.model.Person;
import com.example.demo.person.repository.PersonRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository repository;
    private PersonMapper mapper;

    public PersonServiceImpl(PersonRepository repository, PersonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    @Override
    public List<PersonDTO> findAll(){
        return mapper.mapToDTO(repository.findAll()) ;
    }

    @Override
    public PersonDTO findById(Integer id) {
        Person person = repository.findById(id).orElseThrow(()-> new RuntimeException("Person with given id does not exists"));
        return mapper.mapToDTO(person);
    }

    @Override
    public PersonDTO save(CreateOrUpdatePersonDTO newPerson) {
       Person person = mapper.mapTo(newPerson);
       person = repository.save(person);
       return mapper.mapToDTO(person);
    }

    @Override
    public PersonDTO update(Integer id, CreateOrUpdatePersonDTO newPerson) {
        Person person =  repository.findById(id).orElseThrow(()-> new RuntimeException("No entity with given id found"));
        person = mapper.mapTo(person, newPerson);
        repository.save(person);
        return mapper.mapToDTO(person);
    }
}
