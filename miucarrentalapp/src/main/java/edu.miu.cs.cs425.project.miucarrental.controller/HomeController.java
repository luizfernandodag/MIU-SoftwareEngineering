package edu.miu.cs.cs425.project.miucarrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/", "/index", "/home", "/miucarrental/home"})
    public String showHomepage() {
        return "public/home";
    }

}
