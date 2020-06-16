package edu.miu.cs.cs425.project.miucarrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


    @GetMapping(value = {"/miucarrental/public/login" })
    public String showLoginPage() {
        return "public/login";
    }

    @GetMapping(value = {"/miucarrental/public/logout"})
    public String logout() {
        return "public/home";
    }

}
