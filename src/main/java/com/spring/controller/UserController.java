package com.spring.controller;

import com.spring.dao.model.User;
import com.spring.exceptions.UserAlreadyExistException;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/registration")
    public String showRegistrationPage() {
        return "registration";
    }

    @PostMapping(path = "/registration")
    public String register(@ModelAttribute("userForm") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registration";
        }

        try {
            userService.register(user);
        } catch (UserAlreadyExistException ex) {
            model.addAttribute("message", "Account with provided email already exists");
            return "registration";
        }

        return "redirect:login";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/findAllUsers")
    public ModelAndView showAllUsersPage(ModelAndView model){
        List<User> users = userService.findAll();
        model.addObject("users", users);
        model.setViewName("findAllUsers");
        return model;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/delete")
    public RedirectView delete(@RequestParam("id")UUID uuid){
        User user = userService.findById(uuid);
        userService.delete(user);
        return new RedirectView("/user/findAllUsers");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "findUserByEmail")
    public ModelAndView findUserByEmail(@RequestParam("email") String email, ModelAndView model) {
        User user = userService.findByEmail(email);
        model.addObject("user", user);
        model.setViewName("findUserByEmail");
        return model;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "findUserById")
    public ModelAndView findUserById(@RequestParam("id") UUID uuid, ModelAndView model) {
        User user = userService.findById(uuid);
        model.addObject("user", user);
        model.setViewName("findUserById");
        return model;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(path = "/form/update")
    public String showUpdateUserForm(@RequestParam("id") UUID uuid, Model model) {
        User user = userService.findById(uuid);
        model.addAttribute("user", user);
        return "updateUserForm";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(path = "/update")
    public RedirectView update(User user) {
        userService.update(user);
        return new RedirectView("/user/findAllUsers");
    }

    @ModelAttribute("userForm")
    public User defaultUser() {
        return new User();
    }
}
