package com.mvcspring.controller;

import com.mvcspring.DAO.UserDAO;
import com.mvcspring.interfaces.CRUDController;
import com.mvcspring.interfaces.CRUDDao;
import com.mvcspring.models.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController implements CRUDController {
    private final UserDAO userDAO = new UserDAO();

    @GetMapping("/all")
    @Override
    public ResponseEntity<List<User>> getAll() {
        // Retrieve user data
        List<User> users = userDAO.getAll();

        // Set the appropriate headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Return the list of users with the headers
        return new ResponseEntity<>(users, headers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<User> getById(@PathVariable int id) {
        User user = userDAO.getById(id);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @Override
    public ResponseEntity<User> add(@RequestBody User user) {
        userDAO.add(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping
    @Override
    public ResponseEntity<User> update(@RequestBody User user) {
        User existingUser = userDAO.getById(user.getId());
        if (existingUser != null) {
            user.setId(user.getId());
            userDAO.update(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable int id) {
        User existingUser = userDAO.getById(id);
        if (existingUser != null) {
            userDAO.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
