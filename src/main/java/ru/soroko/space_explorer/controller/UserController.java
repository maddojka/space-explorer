package ru.soroko.space_explorer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.soroko.space_explorer.exception.ResourceNotFoundException;
import ru.soroko.space_explorer.model.User;
import ru.soroko.space_explorer.repository.UserRepository;


@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        userRepository.save(user);
        return user;
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User show(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(id + " Not Found"));
    }
}
