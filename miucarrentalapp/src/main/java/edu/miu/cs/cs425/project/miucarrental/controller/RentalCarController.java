package edu.miu.cs.cs425.project.miucarrental.controller;

import edu.miu.cs.cs425.project.miucarrental.model.Car;
import edu.miu.cs.cs425.project.miucarrental.model.RentalCar;
import edu.miu.cs.cs425.project.miucarrental.model.User;
import edu.miu.cs.cs425.project.miucarrental.service.CarService;
import edu.miu.cs.cs425.project.miucarrental.service.RentalCarService;
import edu.miu.cs.cs425.project.miucarrental.service.UserService;
import edu.miu.cs.cs425.project.miucarrental.util.GeneratorUtils;
import edu.miu.cs.cs425.project.miucarrental.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
public class RentalCarController {
    @Autowired
    private RentalCarService rentalCarService;
    @Autowired
    private CarService carService;
    @Autowired
    private UserService userService;


    @GetMapping(value = {"/miucarrent/dashboard/rentalCar/list", "/dashboard/rentalCar/list"})
    public ModelAndView listRentalCar() {
        ModelAndView modelAndView = new ModelAndView();

        List<User> users = userService.getAllUsers();
        List<RentalCar> rentalCars = rentalCarService.findAll();

        User user = Utils.getSelectedUser(users);
        if(user !=null){
            modelAndView.addObject("userId", user.getUserId());
        }

        modelAndView.addObject("rentalCars", rentalCars);
        modelAndView.addObject("searchString", "");
        modelAndView.addObject("RentalCarsCount", rentalCars.size());
        modelAndView.setViewName("rent/list");
        return modelAndView;

    }

    @GetMapping(value = {"/miucarrent/dashboard/rentalCar/new", "/dashboard/rentalCar/new"})
    public String displayNewRentalCarForm(Model model,
                                          @RequestParam(required = false) Integer carId) {
        RentalCar rentalCar = new RentalCar();
        List<User> users = userService.getAllUsers();
        List<Car> cars = carService.findAll();

        // Set car
        if (carId != null && carId >= 0) {
            Car selectedCar = carService.findById(Long.valueOf(carId));
            model.addAttribute("selectedCar", selectedCar);
            rentalCar.setCar(selectedCar);
            Utils.selectedCar = selectedCar;
        }

        // Set User
        User user = Utils.getSelectedUser(users);
        rentalCar.setUser(user);

        System.out.println(rentalCar);
        model.addAttribute("rentalCar", rentalCar);
        model.addAttribute("cars", cars);
        model.addAttribute("users", users);
        return "/rent/new";
    }


    @PostMapping(value = {"/miucarrent/dashboard/rentalCar/new", "/dashboard/rentalCar/new"})
    public String addNewRentalCar(@Valid @ModelAttribute("rentalCar") RentalCar rentalCar,
                                  BindingResult bindingResult, Model model) {
        List<User> users = userService.getAllUsers();

        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("users", userService.getAllUsers());
            return "/rent/new";
        }

        User user = Utils.getSelectedUser(users);
        rentalCar.setUser(user);
        rentalCar.setCar(Utils.getSelectedCar());

        System.out.println(rentalCar);
        rentalCar = rentalCarService.save(rentalCar);
        return "redirect:/dashboard/rentalCar/list";
    }

    @GetMapping(value = {"/miucarrent//dashboard/rentalCar/edit/{RentalCarId}", "/dashboard/rentalCar/edit/{RentalCarId}"})
    public String editRentalCar(@PathVariable Integer RentalCarId, Model model) {
        RentalCar RentalCar = rentalCarService.findById(RentalCarId);

        if (RentalCar != null) {
            model.addAttribute("RentalCar", RentalCar);
            return "/rent/edit";
        }
        return "/rent/list";
    }

    @PostMapping(value = {"/miucarrent/dashboard/rentalCar/edit", "/dashboard/rentalCar/edit"})
    public String updateRentalCar(@Valid @ModelAttribute("RentalCar") RentalCar RentalCar,
                                  BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/rent/edit";
        }

        return "redirect:/dashboard/rentalCar/list";
    }

    @GetMapping(value = {"/miucarrent/dashboard/rentalCar/delete/{RentalCarId}", "/dashboard/rentalCar/delete/{RentalCarId}"})
    public String deleteRentalCar(@PathVariable Integer RentalCarId, Model model) {
        rentalCarService.deleteById(RentalCarId);
        return "redirect:/dashboard/rentalCar/list";

    }

    @GetMapping(value = {"/miucarrent/dashboard/rentalCar/search", "/dashboard/rentalCar/search"})
    public ModelAndView searchRentalCars(@RequestParam String searchString) {
        ModelAndView modelAndView = new ModelAndView();

        List<RentalCar> RentalCars = rentalCarService.searchRentalCars(searchString);

        modelAndView.addObject("RentalCars", RentalCars);
        modelAndView.addObject("searchString", searchString);
        modelAndView.addObject("RentalCarsCount", RentalCars.size());
        modelAndView.setViewName("rentalCar/list");
        return modelAndView;
    }


}
