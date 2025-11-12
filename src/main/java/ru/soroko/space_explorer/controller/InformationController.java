package ru.soroko.space_explorer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InformationController {

    @Value("${app.welcome-message}")
    private String welcomeMessage;

    @Value("${app.admin-email}")
    private String adminEmail;

    @GetMapping("/welcome")
    public String welcome() {
        return welcomeMessage;
    }

    @GetMapping("/email")
    public String email() {
        return adminEmail;
    }
}
