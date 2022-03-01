package by.tms;

import org.springframework.stereotype.Controller;
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
    public String resl(Calc calc) {
        return "redirect:/calc";
    }
}
