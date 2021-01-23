package com.api.nuvu.NuvuAPI.service.api;

import com.api.nuvu.NuvuAPI.commons.GenericServiceAPI;
import com.api.nuvu.NuvuAPI.dao.api.IPersonDAOAPI;
import com.api.nuvu.NuvuAPI.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceAPI extends GenericServiceAPI<Person, Integer> implements IPersonServiceAPI {

    @Autowired
    private IPersonDAOAPI personDaoAPI;

    @Override
    public CrudRepository<Person, Integer> getDao() {
        return personDaoAPI;
    }
}
