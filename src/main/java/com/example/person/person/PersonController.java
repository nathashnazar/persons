package com.example.person.person;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ResourceBundle;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/persons")
    public ResponseEntity create(@RequestBody Person person){
        return ResponseEntity.ok(personRepository.save(person));
    }

    @GetMapping("/persons")
    public ResponseEntity getAllPersons(){
        return ResponseEntity.ok(personRepository.findAll());
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity getPersonById(@PathVariable("id") Integer id){
        return ResponseEntity.of(personRepository.findById(id));
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity edit(@PathVariable("id") Integer id, @RequestBody Person person){
        Person existing = personRepository.findById(id).get();
        existing.setName(person.getName());
        existing.setMobile(person.getMobile());
        //TODO
        return ResponseEntity.ok(personRepository.save(existing));
    }

    @GetMapping("/persons/search/by-name")
    public ResponseEntity searchByName(@RequestParam("name") String name){
        return ResponseEntity.ok(personRepository.findByNameContainingIgnoreCase(name));
    }

    @GetMapping("/persons/search/by-mobile")
    public ResponseEntity searchByMobile(@RequestParam("mobile") String mobile){
        return ResponseEntity.ok(personRepository.findByMobile(mobile));
    }

    @GetMapping("/persons/search/by-mobile-any")
    public ResponseEntity searchByMobileCointaining(@RequestParam("mobile") String mobile){
        return ResponseEntity.ok(personRepository.findByMobileContainsIgnoreCase(mobile));
    }

    @GetMapping("/persons/search/by-mobile-starting")
    public ResponseEntity searchByMobileStarting(@RequestParam("mobile")String mobile){
        return ResponseEntity.ok(personRepository.findByMobileStartingWith(mobile));
    }
}
