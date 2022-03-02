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
    public String result(Calc calc, Model model) {
        double resultValue = 0;

        if (calc == null) {
            model.addAttribute("result", "no operation selected");
        } else if (calc.getOperation().equals("sum")) {
            resultValue = calc.getValue1() + calc.getValue2();
        } else if (calc.getOperation().equals("dif")) {
            resultValue = calc.getValue1() - calc.getValue2();
        } else if (calc.getOperation().equals("div")) {
            resultValue = calc.getValue1() / calc.getValue2();
        } else if (calc.getOperation().equals("mult")) {
            resultValue = calc.getValue1() * calc.getValue2();
        } else {
            model.addAttribute("result", "not support operation");
        }

        model.addAttribute("result", String.valueOf(resultValue));

        return "calc";
    }
}
