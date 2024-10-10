package com.example.demo.person.controller;

import com.example.demo.person.dto.CreateOrUpdatePersonDTO;
import com.example.demo.person.dto.PersonDTO;
import com.example.demo.person.services.PersonService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// adnotacja przeznaczona z RESTs
@RestController
@RequestMapping("persons")
public class PersonController {

    private PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public List<PersonDTO> getAll(){
        return service.findAll();
    }

    //persons/2
    @GetMapping("/{id}")
    public PersonDTO getById(@PathVariable Integer id){
        return  service.findById(id);
    }

    // persons?id=1
    @GetMapping(params = {"id"})
    public PersonDTO getByIdWithAttribute(@RequestParam("id") Integer id){
        return  service.findById(id);
    }

    @PostMapping
    public PersonDTO createPerson(@RequestBody CreateOrUpdatePersonDTO newPerson){
        return service.save(newPerson);
    }

    @PutMapping("/{id}")
    public PersonDTO updatePerson(@PathVariable Integer id, CreateOrUpdatePersonDTO person){
        return  service.update(id, person);
    }
}
