package springcrudapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springcrudapp.model.User;
import springcrudapp.service.UserDetailsServiceImpl;

@Controller
@RequestMapping("/")
public class AdminController {
    private UserDetailsServiceImpl userService;

    @Autowired
    public AdminController(UserDetailsServiceImpl userService) {this.userService = userService;}

    @GetMapping("/index")
    public String index() { return "index"; }

    @GetMapping("/admin")
    public String allUsers(Model model) {
        model.addAttribute("allUsers", userService.allUsers());
        return "admin";
    }

    @GetMapping("admin/{id}")
    public String userById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "user";
    }

    @GetMapping("admin/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/admin")
    public String create(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("admin/{id}/edit")
    public String editPage(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "edit";
    }

    @PatchMapping("admin/{id}")
    public String edit(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/admin";
    }

    @GetMapping("admin/{id}/delete")
    public String delete(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/login")
    public String login(Model model) {

        return "login";
    }
}
