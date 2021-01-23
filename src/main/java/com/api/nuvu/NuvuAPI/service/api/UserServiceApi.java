package com.api.nuvu.NuvuAPI.service.api;

import com.api.nuvu.NuvuAPI.commons.GenericServiceAPI;
import com.api.nuvu.NuvuAPI.model.Person;
import com.api.nuvu.NuvuAPI.model.UserLogin;
import org.springframework.data.repository.CrudRepository;

public class UserServiceApi extends GenericServiceAPI<UserLogin, Integer> implements IUserServiceApi {

    @Override
    public CrudRepository<UserLogin, Integer> getDao() {
        return null;
    }
}
