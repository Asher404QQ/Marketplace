package ru.kors.marketplace.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kors.marketplace.models.User;
import ru.kors.marketplace.service.UserService;


@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("registration")
    public String createUser(User user, Model model){
        if(!userService.createUser(user)) {
            model.addAttribute("errorMassage", "Пользователь с таким email уже существует");
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/hello")
    public String securityUrl(){
        return "hello";
    }
}
