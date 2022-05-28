package uz.pdp.app6task3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.app6task3.entity.Address;
import uz.pdp.app6task3.entity.School;
import uz.pdp.app6task3.payload.SchoolDto;
import uz.pdp.app6task3.repository.SchoolRepository;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/school")
public class SchoolController {

    @Autowired
    SchoolRepository schoolRepository;

    @Transactional
    @PostMapping
    public HttpEntity<?> addSchool(@RequestBody SchoolDto schoolDto) {
        Address address = new Address(
                schoolDto.getCity(),
                schoolDto.getStreet());

        School school = new School(
                schoolDto.getName(),
                address);

        School savedSchool = schoolRepository.save(school);
        return ResponseEntity.ok(savedSchool);
    }

}
