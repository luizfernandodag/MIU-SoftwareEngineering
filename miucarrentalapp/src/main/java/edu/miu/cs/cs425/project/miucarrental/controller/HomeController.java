package edu.miu.cs.cs425.project.miucarrental.controller;

import edu.miu.cs.cs425.project.miucarrental.model.CarStatusEnum;
import edu.miu.cs.cs425.project.miucarrental.model.CarType;
import edu.miu.cs.cs425.project.miucarrental.model.DistanceMile;
import edu.miu.cs.cs425.project.miucarrental.model.PaymentOption;
import edu.miu.cs.cs425.project.miucarrental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @Autowired
    private CarService carService;

    @GetMapping(value = {"/", "/index", "/home", "/miucarrental/public/home"})
    public String showHomePage(Model model) {
        model.addAttribute("cars", carService.findAll());
        return "public/home";
    }

    @GetMapping(value = {"/car/search", "/index/car/search", "/home/car/search", "/miucarrental/public/home/car/search"})
    public ModelAndView searchCarPaged(@RequestParam String searchString, @RequestParam(defaultValue = "0") int pageno) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cars", carService.searchDataPaged(searchString, 0));
        modelAndView.addObject("searchString", searchString);
        modelAndView.addObject("currentPageNo", pageno);
        modelAndView.setViewName("public/home");
        return modelAndView;
    }

    @GetMapping(value = {"/car/filter", "/index/car/filter", "/home/car/filter", "/miucarrental/public/home/car/filter"})
    public ModelAndView filterCarPaged(@RequestParam(defaultValue = "TWENTY", required = false) DistanceMile distanceMile,
                                       @RequestParam(defaultValue = "Available", required = false) CarStatusEnum status,
                                       @RequestParam(defaultValue = "Economy", required = false) CarType type,
                                       @RequestParam(defaultValue = "PickUp", required = false) PaymentOption payment,
                                       @RequestParam(defaultValue = "0") int pageno) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cars", carService.filterDataPaged(distanceMile,
                status,
                type,
                payment,
                0));
        modelAndView.addObject("currentPageNo", pageno);
        modelAndView.setViewName("public/home");
        return modelAndView;
    }


    @GetMapping(value = {"/dashboard", "/miucarrental/dashboard"})
    public String showDashboard() {
        return "dashboard/index";
    }

    @GetMapping(value = {"/public/about", "/miucarrental/public/about"})
    public String about() {
        return "public/about";
    }

    @GetMapping(value = {"/public/virtualtour", "/miucarrental/public/virtualtour"})
    public String virtualtour() {
        return "public/virtualtour";
    }

}
