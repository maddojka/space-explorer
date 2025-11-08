package ru.soroko.space_explorer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Добро пожаловать во вселенную!";
    }

    @GetMapping("/about")
    public String about() {
        return "This is project about everything related to space: planets, stars, unknown objects etc.";
    }
}
