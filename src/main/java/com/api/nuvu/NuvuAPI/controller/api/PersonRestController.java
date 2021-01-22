package com.api.nuvu.NuvuAPI.controller.api;

import com.api.nuvu.NuvuAPI.model.Person;
import com.api.nuvu.NuvuAPI.service.api.IPersonServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/")
@CrossOrigin("*")
public class PersonRestController {

    @Autowired
    private IPersonServiceAPI personServiceAPI;

    @GetMapping(value = "/all")
    public List<Person> getAll() {
        return personServiceAPI.getAll();
    }
}
