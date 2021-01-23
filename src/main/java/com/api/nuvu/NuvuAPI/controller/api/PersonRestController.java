package com.api.nuvu.NuvuAPI.controller.api;

import com.api.nuvu.NuvuAPI.model.Person;
import com.api.nuvu.NuvuAPI.service.api.IPersonServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/")
@CrossOrigin("*")
public class PersonRestController {

    @Autowired
    private IPersonServiceAPI personServiceAPI;

    @GetMapping(value="/all")
    public List<Person> getAll() {
        return personServiceAPI.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public Person find(@PathVariable Integer id) {
        return personServiceAPI.get(id);
    }


    @PostMapping(value = "/save")
    public ResponseEntity<Person> save(@RequestBody Person persona) {
        Person obj = personServiceAPI.save(persona);
        return new ResponseEntity<Person>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Person> delete(@PathVariable Integer id) {
        Person persona = personServiceAPI.get(id);
        if (persona != null) {
            personServiceAPI.delete(id);
        }else {
            return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Person>(persona, HttpStatus.OK);
    }
}
