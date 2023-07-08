package com.mvcspring.interfaces;

import com.mvcspring.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CRUDController<Type> {
    ResponseEntity<List<Type>> getAll();
//    List<Type> getAll();

    ResponseEntity<Type> getById(int id);

    ResponseEntity<Type> add(User user);

    ResponseEntity<Type> update(User user);

    ResponseEntity<Void> delete(int id);



}
