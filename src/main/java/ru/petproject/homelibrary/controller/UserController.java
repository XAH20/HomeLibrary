package ru.petproject.homelibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.petproject.homelibrary.service.UserService;

import java.util.Map;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    public UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String userList(Model model) {
        userService.userList(model);
        return "userList";
    }

    @GetMapping("{userID}")
    public String userEditForm(@PathVariable Integer userID, Model model) {
        userService.userEditForm(userID, model);
        return "userEdit";
    }

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam Integer userID) {
        userService.userSave(username, form, userID);
        return "redirect:/user";
    }
}
