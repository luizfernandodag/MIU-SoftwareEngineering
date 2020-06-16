package edu.miu.cs.cs425.project.miucarrental.controller;

import edu.miu.cs.cs425.project.miucarrental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private CarService carService;

    @GetMapping(value = {"/", "/index", "/home", "/miucarrental/public/home"})
    public String showHomePage(Model model) {
        model.addAttribute("cars", carService.findAll());
        return "public/home";
    }

    @GetMapping(value = { "/dashboard", "/miucarrental/dashboard"})
    public String showDashboard() {
        return "dashboard/index";
    }

    @GetMapping(value = {"/public/about","/miucarrental/public/about"})
    public String about() {
        return "public/about";
    }

    @GetMapping(value = {"/public/virtualtour","/miucarrental/public/virtualtour"})
    public String virtualtour() {
        return "public/virtualtour";
    }

}
