package by.tms.controller;

import by.tms.dao.UserDAO;
import by.tms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {



    private final UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("users", userDAO.getAll());
        return "user/users";
    }

    @GetMapping("/{id}")
    public String showById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDAO.getById(id));
        return "user/user";
    }

    @GetMapping("/reg")
    public String newUser(Model model) {
        model.addAttribute("newUser", new User());
        return "user/reg";
    }

    @PostMapping("/reg")
    public String createUser(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "user/reg";
        }

        userDAO.save(user);
        return "redirect:/user";
    }
}
