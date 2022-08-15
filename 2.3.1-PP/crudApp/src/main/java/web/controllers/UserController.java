package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUsers(Model model){
        model.addAttribute("users",userService.findAll());
        return "users/all";
    }

    @GetMapping("/{id}")
    public String getUser(Model model,@PathVariable("id") long id){
        model.addAttribute("user",userService.findById(id));
        return "/users/show";
    }

    @GetMapping("/new")
    public String createUsersForm(@ModelAttribute("user") User user) {
        return "/users/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String userDelete(@PathVariable("id") long id){
        userService.removeUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable("id") long id,Model model){
        model.addAttribute("user",userService.findById(id));
        return "users/update";
    }

    @PostMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user){
        userService.update(user);
        return "redirect:/users";
    }
}
