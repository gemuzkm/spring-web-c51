package by.tms.controller;

import by.tms.entity.Operation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calc")
public class CalcController {

    @GetMapping
    public String calc(@ModelAttribute("calcOperation") Operation operation) {
        return "calc";
    }

    @PostMapping
    public String result(@ModelAttribute("calcOperation")  Operation operation, Model model) {
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
