package com.api.nuvu.NuvuAPI.commons;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericServiceAPI<T, ID extends Serializable> implements IGenericServiceAPI<T, ID> {

    @Override
    public T save(T entity) {
        return getDao().save(entity);
    }

    @Override
    public void delete(ID id) {
        getDao().deleteById(id);
    }

    @Override
    public T get(ID id) {
        Optional<T> dao = getDao().findById(id);
        if(dao.isPresent()) {
            return dao.get();
        }

        return null;
    }

    @Override
    public List<T> getAll() {
        List<T> list = new ArrayList<>();
        getDao().findAll().forEach(obj -> list.add(obj));
        return list;
    }

    public abstract CrudRepository<T, ID> getDao();
}
