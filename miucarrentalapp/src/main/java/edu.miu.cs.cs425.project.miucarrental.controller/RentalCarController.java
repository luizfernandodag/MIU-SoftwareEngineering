package edu.miu.cs.cs425.project.miucarrental.controller;

import edu.miu.cs.cs425.project.miucarrental.model.RentalCar;
import edu.miu.cs.cs425.project.miucarrental.service.RentalCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
public class RentalCarController{
//    @Autowired
//    private RentalCarService rentalCarService;
//    public RentalCarController(RentalCarService RentalCarService) {
//        this.rentalCarService = RentalCarService;
//    }
//
//    @GetMapping(value = {"/miucarrent/RentalCar/list", "/RentalCar/list"})
//    public ModelAndView listRentalCar() {
//        ModelAndView modelAndView = new ModelAndView();
//
//        List<RentalCar> RentalCars = rentalCarService.findAll();
//        modelAndView.addObject("RentalCars", RentalCars);
//        modelAndView.addObject("searchString", "");
//        modelAndView.addObject("RentalCarsCount", RentalCars.size());
//        modelAndView.setViewName("RentalCar/list");
//        return modelAndView;
//
//    }
//
//    @GetMapping(value = {"/miucarrent/RentalCar/new","/RentalCar/new"})
//    public String displayNewRentalCarForm(Model model) {
//        model.addAttribute("RentalCar", new RentalCar());
//        return "RentalCar/new";
//    }
//
//
//    @PostMapping(value = {"/miucarrent/RentalCar/new","/RentalCar/new"})
//    public String addNewRentalCar(@Valid @ModelAttribute("RentalCar") RentalCar rentalcar,
//                             BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("errors", bindingResult.getAllErrors());
//            return "RentalCar/new";
//        }
//        rentalcar = rentalCarService.save(rentalcar);
//        return "redirect:/miucarrent/RentalCar/list";
//    }
//
//    @GetMapping(value = {"/miucarrent/RentalCar/edit/{RentalCarId}","/RentalCar/edit/{RentalCarId}"})
//    public String editRentalCar(@PathVariable Integer RentalCarId, Model model) {
//        RentalCar RentalCar = rentalCarService.findById(RentalCarId);
//
//        if (RentalCar != null) {
//            model.addAttribute("RentalCar", RentalCar);
//            return "RentalCar/edit";
//        }
//        return "RentalCar/list";
//    }
//
//    @PostMapping(value = {"/miucarrent/RentalCar/edit","/RentalCar/edit"})
//    public String updateRentalCar(@Valid @ModelAttribute("RentalCar") RentalCar RentalCar,
//                             BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("errors", bindingResult.getAllErrors());
//            return "RentalCar/edit";
//        }
//
//        return "redirect:/miucarrent/RentalCar/list";
//    }
//
//    @GetMapping(value = {"/miucarrent/RentalCar/delete/{RentalCarId}","/RentalCar/delete/{RentalCarId}"})
//    public String deleteRentalCar(@PathVariable Integer RentalCarId, Model model) {
//        rentalCarService.deleteById(RentalCarId);
//        return "redirect:/miucarrent/RentalCar/list";
//
//    }
//
//    @GetMapping(value = {"/miucarrent/RentalCar/search", "/RentalCar/search"})
//    public ModelAndView searchRentalCars(@RequestParam String searchString) {
//        ModelAndView modelAndView = new ModelAndView();
//
//        List<RentalCar> RentalCars = rentalCarService.searchRentalCars(searchString);
//
//        modelAndView.addObject("RentalCars", RentalCars);
//        modelAndView.addObject("searchString", searchString);
//        modelAndView.addObject("RentalCarsCount", RentalCars.size());
//        modelAndView.setViewName("RentalCar/list");
//        return modelAndView;
//    }


}
