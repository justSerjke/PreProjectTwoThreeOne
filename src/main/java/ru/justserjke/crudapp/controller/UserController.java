package ru.justserjke.crudapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.justserjke.crudapp.model.User;
import ru.justserjke.crudapp.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/")
    public String showAllUser(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "users";
    }

    @RequestMapping("/add")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-edit";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit")
    public String createOrUpdateUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable(value = "id") Long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "user-edit";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/";
    }
}
