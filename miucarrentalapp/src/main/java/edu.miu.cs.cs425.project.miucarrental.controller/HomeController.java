package edu.miu.cs.cs425.project.miucarrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/", "/index", "/home", "/miucarrental/home"})
    public String showHomePage() {
        return "public/home";
    }

    @GetMapping(value = { "/login", "/miucarrental/login"})
    public String showLoginPage() {
        return "public/login";
    }

    @GetMapping(value = { "/dashboard", "/miucarrental/dashboard"})
    public String showDashboar() {
        return "dashboard/index";
    }

}
