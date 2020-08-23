package ru.petproject.homelibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.petproject.homelibrary.domain.Role;
import ru.petproject.homelibrary.domain.User;
import ru.petproject.homelibrary.repos.UserRepo;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    public UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void userList(Model model) {
        model.addAttribute("users", userRepo.findAll());
    }

    public void userEditForm(Integer userID, Model model) {
        model.addAttribute("user", userRepo.findByUserID(userID));
        model.addAttribute("roles", Role.values());
    }

    public void userSave(String username, Map<String, String> form, Integer userID) {
        User user = userRepo.findByUserID(userID);
        user.setUsername(username);
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key : form.keySet()) {
            if(roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepo.save(user);
    }
}
