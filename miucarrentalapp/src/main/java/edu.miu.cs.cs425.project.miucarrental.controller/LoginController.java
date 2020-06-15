package edu.miu.cs.cs425.project.miucarrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping(value = {"/public/login","/miucarrental/public/login"})
    public String login() {
        return "public/login";
    }
}
