package springcrudapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import springcrudapp.service.UserDetailsServiceImpl;

@Controller
@RequestMapping("/")
public class UsersController {
    private UserDetailsServiceImpl userService;

    @Autowired
    public UsersController(UserDetailsServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public String userByIdforUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));

        return "redirect: user/{id}";
    }

}
