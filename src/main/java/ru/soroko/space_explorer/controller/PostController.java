package ru.soroko.space_explorer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.soroko.space_explorer.exception.ResourceNotFoundException;
import ru.soroko.space_explorer.model.Post;
import ru.soroko.space_explorer.repository.PostRepository;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @PostMapping("/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {
        postRepository.save(post);
        return post;
    }

    @GetMapping("/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post show(@PathVariable Long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(id + " Not Found"));
    }
}
