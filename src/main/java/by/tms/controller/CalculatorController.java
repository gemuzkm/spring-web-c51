package by.tms.controller;

import by.tms.entity.Operation;
import by.tms.service.СalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/calc")
public class CalculatorController {

    @GetMapping
    public String calc(@ModelAttribute("calcOperation") Operation operation) {
        return "calculator/calc";
    }

    @PostMapping
    public String result(@Valid @ModelAttribute("calcOperation")  Operation operation, BindingResult bindingResult, Model model) {
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

        model.addAttribute("msgResult", СalculatorService.getResult(operation));

        return "calculator/calc";
    }
}