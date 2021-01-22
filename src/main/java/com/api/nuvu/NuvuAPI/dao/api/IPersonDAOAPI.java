package com.api.nuvu.NuvuAPI.dao.api;

import com.api.nuvu.NuvuAPI.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface IPersonDAOAPI extends CrudRepository<Person, Long> {
}