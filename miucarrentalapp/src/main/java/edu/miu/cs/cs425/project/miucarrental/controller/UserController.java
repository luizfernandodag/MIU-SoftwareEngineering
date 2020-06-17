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
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"/miucarrental/dashboard/user/list", "/dashboard/user/list"})
    public ModelAndView listUser() {
        ModelAndView modelAndView = new ModelAndView();

        List<User> Users = userService.getAllUsers();
        modelAndView.addObject("users", Users);
        modelAndView.addObject("searchString", "");
        modelAndView.addObject("UsersCount", Users.size());
        modelAndView.setViewName("user/list");
        return modelAndView;

    }

    @GetMapping(value = {"/miucarrental/dashboard/user/new", "/dashboard/user/new"})
    public String displayNewUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user/new";
    }


    @PostMapping(value = {"/miucarrental/user/new", "/user/new"})
    public String addNewUser(@Valid @ModelAttribute("User") User User,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "user/new";
        }
        User = userService.saveUser(User);
        return "redirect:/miucarrental/user/list";
    }

    @GetMapping(value = {"/miucarrental/dashboard/user/edit/{userId}", "/dashboard/user/edit/{userId}"})
    public String editUserForm(@PathVariable Integer userId, Model model) {
        User User = userService.getUserById(userId);

        if (User != null) {
            model.addAttribute("user", User);
            return "user/edit";
        }
        return "user/list";
    }

    @PostMapping(value = {"/miucarrental/dashboard/user/edit", "/dashboard/user/edit"})
    public String updateUser(@Valid @ModelAttribute("user") User user,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "user/edit";
        }

        user = userService.saveUser(user);
        return "redirect:/dashboard/user/list";
    }

    @GetMapping(value = {"/miucarrental/dashboard/user/delete/{UserId}", "/dashboard/user/delete/{UserId}"})
    public String deleteUser(@PathVariable Integer UserId, Model model) {
        userService.deleteUserById(UserId);
        return "redirect:/dashboard/user/list";

    }

    @GetMapping(value = {"/dashboard/user/search", "/miucarrental/dashboard/user/search"})
    public ModelAndView searchUserPaged(@RequestParam String searchString, @RequestParam(defaultValue = "0") int pageno) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users", userService.searchUsers(searchString, 0));
        modelAndView.addObject("searchString", searchString);
        modelAndView.addObject("currentPageNo", pageno);
        modelAndView.setViewName("/user/list");
        return modelAndView;
    }


}
