package ru.soroko.space_explorer.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.soroko.space_explorer.model.Post;
import ru.soroko.space_explorer.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final List<User> users = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<User>> index(@RequestParam(defaultValue = "10") Integer limit) {
        var result = users.stream().limit(limit).toList();
        return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        if (user.getEmail().isBlank()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        users.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> show(@PathVariable Long id) {
        var user = users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
        if (user.isPresent()) {
            return ResponseEntity.ok().body(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User data) {
        var userToUpdate = users.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
        if (userToUpdate.isPresent()) {
            var user = userToUpdate.get();
            user.setId(data.getId());
            user.setName(data.getName());
            user.setEmail(data.getEmail());
            return ResponseEntity.ok().body(user);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}") // Удаление страницы
    public ResponseEntity<Void> destroy(@PathVariable Long id) {
        users.removeIf(p -> p.getId().equals(id));
        return ResponseEntity.noContent().build();
    }
}
