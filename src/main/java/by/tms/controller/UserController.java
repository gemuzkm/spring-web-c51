package by.tms.controller;

import by.tms.dao.Hibernate.HibernateUserDAO;
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

    @Autowired
    private HibernateUserDAO hibernateUserDAO;

    @GetMapping()
    public String showAllUsers(Model model) {
//        model.addAttribute("users", userDAOInMemory.getAll());

        //init test data users
//        if (userDAOHibernate.findById(1) == null) {
//
//            User user1 = new User();
//            user1.setName("user1");
//            user1.setPassword("user1");
//            user1.setEmail("user1@gmail.com");
//            userDAOHibernate.save(user1);
//
//            User user2 = new User();
//            user2.setName("user2");
//            user2.setPassword("user2");
//            user2.setEmail("user2@gmail.com");
//            userDAOHibernate.save(user2);
//
//            User user3 = new User();
//            user3.setName("user3");
//            user3.setPassword("user3");
//            user3.setEmail("user3@gmail.com");
//            userDAOHibernate.save(user3);
//        }

        model.addAttribute("users", hibernateUserDAO.findAll());
        return "user/users";
    }

    @GetMapping("/{id}")
    public String showById(@PathVariable("id") long id, Model model) {
//        model.addAttribute("user", userDAOInMemory.getById(id));
        model.addAttribute("user", hibernateUserDAO.findById(id));
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

//        userDAOInMemory.save(user);
        hibernateUserDAO.save(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
 //       model.addAttribute("user", userDAOInMemory.getById(id));
        model.addAttribute("user", hibernateUserDAO.findById(id));
        return "user/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") @ Valid User user,
                         BindingResult bindingResult, @PathVariable("id") long id) {

        if (bindingResult.hasErrors()) {
            return "user/edit";
        }

 //       userDAOInMemory.update(id, user);
        hibernateUserDAO.update(user);
        return "redirect:/user";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
//        userDAOInMemory.delete(id);
        User user = hibernateUserDAO.findById(id);
        hibernateUserDAO.remove(user);
        return "redirect:/user";
    }
}
