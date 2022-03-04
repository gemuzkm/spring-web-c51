package by.tms;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/reg")
    public String reg() {
        return "reg";
    }

    @PostMapping("/reg")
	// результат должен быть после валидируемой модели

    public String reg(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasGlobalErrors()) {
//			Map<String, String> map = new HashMap<>();
			for (FieldError fieldError: bindingResult.getFieldErrors()) {
                model.addAttribute(fieldError.getField(), fieldError.getDefaultMessage());
//				map.put(fieldError.getField(), fieldError.getDefaultMessage());
			}
//		model.addAllAttributes(map);
            return "reg";
		}

		System.out.println(bindingResult.hasErrors());
        return "redirect:test";
    }
}
