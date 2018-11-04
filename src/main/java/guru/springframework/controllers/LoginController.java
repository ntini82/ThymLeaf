package guru.springframework.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import guru.springframework.comands.LoginCommand;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("loginCommand", new LoginCommand());
		return "loginform";
	}
	
	@RequestMapping("logout-success")
	public String yourLoggedOut(Model model) {
		return "logout-success";
	}
	
//	@RequestMapping(value="/dologin", method= RequestMethod.POST)
	public String doLogin(@Valid LoginCommand loginCommand, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "loginform";
		}
		 return "redirect:/";
	}
}
