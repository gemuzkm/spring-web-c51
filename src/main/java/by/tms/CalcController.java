package by.tms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calc")
public class CalcController {

    @GetMapping
    public String calc() {
        return "calc";
    }

    @PostMapping
    public String result(Operation operation, Model model) {
        double resultValue = 0;

        if (operation == null) {
            model.addAttribute("result", "no operation selected");
        } else if (operation.getOperation().equals("sum")) {
            resultValue = operation.getValue1() + operation.getValue2();
        } else if (operation.getOperation().equals("dif")) {
            resultValue = operation.getValue1() - operation.getValue2();
        } else if (operation.getOperation().equals("div")) {
            resultValue = operation.getValue1() / operation.getValue2();
        } else if (operation.getOperation().equals("mult")) {
            resultValue = operation.getValue1() * operation.getValue2();
        } else {
            model.addAttribute("msgResult", "not support operation");
        }

        model.addAttribute("msgResult", String.valueOf(resultValue));

        return "calc";
    }
}
