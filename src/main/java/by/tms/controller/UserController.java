package by.tms.controller;

import by.tms.dao.InMemory.UserDAOInMemory;
import by.tms.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserDAOInMemory userDAOInMemory;

    @Autowired
    public UserController(UserDAOInMemory userDAOInMemory) {
        this.userDAOInMemory = userDAOInMemory;
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("users", userDAOInMemory.getAll());
        return "user/users";
    }

    @GetMapping("/{id}")
    public String showById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDAOInMemory.getById(id));
        return "user/user";
    }

    @GetMapping("/reg")
    public String newUser(@ModelAttribute("user") User user) {
        return "user/reg";
    }

    @PostMapping("/reg")
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "user/reg";
        }

        userDAOInMemory.save(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userDAOInMemory.getById(id));
        return "user/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @ Valid User user,
                         BindingResult bindingResult, @PathVariable("id") int id) {

        if (bindingResult.hasErrors()) {
            return "user/edit";
        }

        userDAOInMemory.update(id, user);
        return "redirect:/user";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userDAOInMemory.delete(id);
        return "redirect:/user";
    }


}
