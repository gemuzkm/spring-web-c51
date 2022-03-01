package by.tms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/reg")
	public String reg(){
		return "reg";
	}

	@PostMapping("/reg")
	public String reg(User user){
		return "redirect:/test";
	}
}
