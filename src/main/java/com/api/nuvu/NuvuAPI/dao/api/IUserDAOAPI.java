package com.api.nuvu.NuvuAPI.dao.api;

import com.api.nuvu.NuvuAPI.model.UserLogin;
import org.springframework.data.repository.CrudRepository;

public interface IUserDAOAPI extends CrudRepository<UserLogin, Integer> {
}
