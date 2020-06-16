package edu.miu.cs.cs425.project.miucarrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/", "/index", "/home", "/miucarrental/public/home"})
    public String showHomePage() {
        return "public/home";
    }

    @GetMapping(value = {"/miucarrental/public/login" })
    public String showLoginPage() {
        return "public/login";
    }

    @GetMapping(value = { "/dashboard", "/miucarrental/dashboard"})
    public String showDashboard() {
        return "dashboard/index";
    }
    //*****************************************************************

//    @GetMapping(value = {"/","/miucarrental","/public/home"})
//    public String home0() {
//        return "redirect:/miucarrental/public/home";
//    }
//
//    @GetMapping(value = {"/public/home","/miucarrental/public/home"})
//    public String home1() {
//        return "public/index";
//    }
//
//
//    @GetMapping(value = {"/secured/home","/miucarrental/secured/home"})
//    public String home2() {
//        return "secured/index";
//    }


    @GetMapping(value = {"/public/about","/miucarrental/public/about"})
    public String about() {
        return "public/about";
    }

    @GetMapping(value = {"/public/virtualtour","/miucarrental/public/virtualtour"})
    public String virtualtour() {
        return "public/virtualtour";
    }




}
