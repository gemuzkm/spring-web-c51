package by.tms.controller;

import by.tms.dao.JPA.JPAHistoryDAO;
import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.HistoryService;
import by.tms.service.СalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/calc")
public class CalculatorController {

    @Autowired
    СalculatorService сalculatorService;

    @Autowired
    HistoryService historyService;

//    @Autowired
//    HibernateHistoryDAO hibernateHistoryDAO;

    @Autowired
    JPAHistoryDAO jpaHistoryDAO;

    @GetMapping
    public String calc(@ModelAttribute("calcOperation") Operation operation) {
        return "calculator/calc";
    }

    @PostMapping
    public String result(@Valid @ModelAttribute("calcOperation")  Operation operation,
                         BindingResult bindingResult, HttpSession session, Model model) {
//        if (bindingResult.hasGlobalErrors()) {
////			Map<String, String> map = new HashMap<>();
//            for (FieldError fieldError: bindingResult.getFieldErrors()) {
//                model.addAttribute(fieldError.getField(), fieldError.getDefaultMessage());
////				map.put(fieldError.getField(), fieldError.getDefaultMessage());
//            }
////		model.addAllAttributes(map);
//            return "calc";
//        }

        if (bindingResult.hasErrors()) {
            return "calculator/calc";
        }

        historyService.save(session, operation);

        model.addAttribute("msgResult", сalculatorService.getResult(operation));
        return "calculator/calc";
    }

    @GetMapping("/history")
    public String history(HttpSession session, Model model) {
        if (session.getAttribute("user") == null) {
            return "redirect:/";
        } else {
//            List<Operation> operationList = hibernateHistoryDAO.findAllByUser((User) session.getAttribute("user"));
            List<Operation> operationList = jpaHistoryDAO.findAllByUser((User) session.getAttribute("user"));
            model.addAttribute("userHistory", operationList);
            return "calculator/history";
        }
    }
}
