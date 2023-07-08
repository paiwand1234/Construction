package com.mvcspring.interfaces;

import com.mvcspring.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface CRUDDao<Type> {

    List<Type> getAll();

    Type getById(int id);

    void add(User user);

    void update(User user);

    void delete(int id);
}
