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

    @GetMapping(value = {"/eregistrar/User/list", "/User/list"})
    public ModelAndView lisUser() {
        ModelAndView modelAndView = new ModelAndView();

        List<User> Users = UserService.getAllUsers();
        modelAndView.addObject("Users", Users);
        modelAndView.addObject("searchString", "");
        modelAndView.addObject("UsersCount", Users.size());
        modelAndView.setViewName("User/list");
        return modelAndView;

    }

    @GetMapping(value = {"/eregistrar/User/new","/User/new"})
    public String displayNewUserForm(Model model) {
        model.addAttribute("User", new User());
        return "User/new";
    }


    @PostMapping(value = {"/eregistrar/User/new","/User/new"})
    public String addNewUser(@Valid @ModelAttribute("User") User User,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "User/new";
        }
        User = UserService.saveUser(User);
        return "redirect:/eregistrar/User/list";
    }

    @GetMapping(value = {"/eregistrar/User/edit/{UserId}","/User/edit/{UserId}"})
    public String editUser(@PathVariable Integer UserId, Model model) {
        User User = UserService.getUserById  (UserId);

        if (User != null) {
            model.addAttribute("User", User);
            return "User/edit";
        }
        return "User/list";
    }

    @PostMapping(value = {"/eregistrar/User/edit","/User/edit"})
    public String updateUser(@Valid @ModelAttribute("User") User User,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "User/edit";
        }

        return "redirect:/eregistrar/User/list";
    }

    @GetMapping(value = {"/eregistrar/User/delete/{UserId}","/User/delete/{UserId}"})
    public String deleteUser(@PathVariable Integer UserId, Model model) {
        UserService.deleteUserById(UserId);
        return "redirect:/eregistrar/User/list";

    }

    @GetMapping(value = {"/eregistrar/User/search", "/User/search"})
    public ModelAndView searchUsers(@RequestParam String searchString) {
        ModelAndView modelAndView = new ModelAndView();

        List<User> Users = UserService.searchUsers(searchString);

        modelAndView.addObject("Users", Users);
        modelAndView.addObject("searchString", searchString);
        modelAndView.addObject("UsersCount", Users.size());
        modelAndView.setViewName("User/list");
        return modelAndView;
    }

    @ModelAttribute("isInternationalList")
    public List<String> populateInternationaList() {
        List<String> nationalities = new ArrayList<String>();
        nationalities.add("no");
        nationalities.add("yes");
        return nationalities;
    }
}
