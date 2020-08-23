package ru.petproject.homelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.petproject.homelibrary.domain.Role;
import ru.petproject.homelibrary.domain.User;
import ru.petproject.homelibrary.repos.UserRepo;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(User user, Model model) {
        User userFromDB = userRepo.findByUsername(user.getUsername());
        if (userFromDB != null) {
            model.addAttribute("message", "User exists!");
            return "registration";
        } else {
            user.setActive(true);
            user.setRoles(Collections.singleton(Role.USER));
            userRepo.save(user);
        }
        return "redirect:/login";
    }
}
