package edu.miu.cs.cs425.project.miucarrental.controller;

import edu.miu.cs.cs425.project.miucarrental.model.User;
import edu.miu.cs.cs425.project.miucarrental.service.UserService;
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
public class UserController {
    @Autowired
   private UserService UserService;
    public UserController(UserService UserService) {
        this.UserService = UserService;
    }

    @GetMapping(value = {"/miucarrental/user/list", "/user/list"})
    public ModelAndView listUser() {
        ModelAndView modelAndView = new ModelAndView();

        List<User> Users = UserService.getAllUsers();
        modelAndView.addObject("users", Users);
        modelAndView.addObject("searchString", "");
        modelAndView.addObject("UsersCount", Users.size());
        modelAndView.setViewName("user/list");
        return modelAndView;

    }

    @GetMapping(value = {"/miucarrental/user/new","/user/new"})
    public String displayNewUserForm(Model model) {
        model.addAttribute("User", new User());
        return "User/new";
    }


    @PostMapping(value = {"/miucarrental/user/new","/user/new"})
    public String addNewUser(@Valid @ModelAttribute("User") User User,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "user/new";
        }
        User = UserService.saveUser(User);
        return "redirect:/miucarrental/user/list";
    }

    @GetMapping(value = {"/miucarrental/user/edit/{UserId}","/user/edit/{UserId}"})
    public String editUser(@PathVariable Integer UserId, Model model) {
        User User = UserService.getUserById  (UserId);

        if (User != null) {
            model.addAttribute("User", User);
            return "user/edit";
        }
        return "user/list";
    }

    @PostMapping(value = {"/miucarrental/user/edit","/user/edit"})
    public String updateUser(@Valid @ModelAttribute("User") User User,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "user/edit";
        }

        return "redirect:/miucarrental/user/list";
    }

    @GetMapping(value = {"/miucarrental/user/delete/{UserId}","/user/delete/{UserId}"})
    public String deleteUser(@PathVariable Integer UserId, Model model) {
        UserService.deleteUserById(UserId);
        return "redirect:/miucarrental/user/list";

    }

    @GetMapping(value = {"/miucarrental/user/search", "/user/search"})
    public ModelAndView searchUsers(@RequestParam String searchString) {
        ModelAndView modelAndView = new ModelAndView();

        List<User> Users = UserService.searchUsers(searchString);

        modelAndView.addObject("Users", Users);
        modelAndView.addObject("searchString", searchString);
        modelAndView.addObject("UsersCount", Users.size());
        modelAndView.setViewName("user/list");
        return modelAndView;
    }


}
