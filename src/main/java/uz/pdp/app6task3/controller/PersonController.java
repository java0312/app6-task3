package uz.pdp.app6task3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.app6task3.entity.Person;
import uz.pdp.app6task3.repository.PersonRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @Transactional
    @PostMapping
    public HttpEntity<?> addPerson(@RequestBody Person person) {
        boolean exists = personRepository.existsByUsername(person.getUsername());
        if (exists)
            return ResponseEntity.status(409).body("Person exists!");

        Person savedPerson = personRepository.save(person);
        return ResponseEntity.status(201).body(savedPerson);
    }

    @GetMapping("/byUsername")
    public HttpEntity<?> getPersonByUsername(@RequestParam String username) {
        return ResponseEntity.ok(personRepository.findByUsername(username));
    }

    @Transactional
    @PutMapping("/{id}")
    public HttpEntity<?> editPerson(@RequestBody Person person, @PathVariable Long id) {
        boolean exists = personRepository.existsById(id);
        if (exists) {
            boolean exists2 = personRepository.existsByUsernameAndIdNot(person.getUsername(), id);
            if (!exists2) {
                personRepository.changePerson(id, person.getName(), person.getUsername());
                return ResponseEntity.status(202).body("Tahrirlandi!");
            }
        }
        return ResponseEntity.status(409).body("Tahrirlanmadi");
    }

}












