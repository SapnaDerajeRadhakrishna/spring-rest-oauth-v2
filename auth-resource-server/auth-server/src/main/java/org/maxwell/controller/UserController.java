package org.maxwell.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    public static final String BASE_URL = "/rest/hello";

    @GetMapping("/public")
    public String publicPage() {
        return "public page";
    }

    @PostMapping("/private")
    public String privatePage() {
        return "private page";
    }

    @PostMapping("/admin")
    public String admin() {
        return "Admin Page";
    }
}
