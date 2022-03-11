package by.tms.controller;

import by.tms.entity.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/calc")
public class CalcController {

    @GetMapping
    public String calc(@ModelAttribute("calcOperation") Operation operation) {
        return "calc";
    }

    @PostMapping
    public String result(@Valid @ModelAttribute("calcOperation")  Operation operation, BindingResult bindingResult, Model model) {
        if (bindingResult.hasGlobalErrors()) {
//			Map<String, String> map = new HashMap<>();
            for (FieldError fieldError: bindingResult.getFieldErrors()) {
                model.addAttribute(fieldError.getField(), fieldError.getDefaultMessage());
//				map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
//		model.addAllAttributes(map);
            return "calc";
        }

        if (bindingResult.hasErrors()) {
            return "calc";
        }

        double resultValue = 0;
        String inputOperation = operation.getOperation();

        switch (inputOperation) {
            case "sum":
                resultValue = operation.getValue1() + operation.getValue2();
                break;
            case "dif":
                resultValue = operation.getValue1() - operation.getValue2();
                break;
            case "div":
                resultValue = operation.getValue1() / operation.getValue2();
                break;
            case "mult":
                resultValue = operation.getValue1() * operation.getValue2();
                break;
            default:
                model.addAttribute("msgResult", "not support operation");
        }

//        if (operation == null) {
//            model.addAttribute("result", "no operation selected");
//        } else if (operation.getOperation().equals("sum")) {
//            resultValue = operation.getValue1() + operation.getValue2();
//        } else if (operation.getOperation().equals("dif")) {
//            resultValue = operation.getValue1() - operation.getValue2();
//        } else if (operation.getOperation().equals("div")) {
//            resultValue = operation.getValue1() / operation.getValue2();
//        } else if (operation.getOperation().equals("mult")) {
//            resultValue = operation.getValue1() * operation.getValue2();
//        } else {
//            model.addAttribute("msgResult", "not support operation");
//        }

        model.addAttribute("msgResult", String.valueOf(resultValue));

        return "calc";
    }
}
