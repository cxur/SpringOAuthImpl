package OAuth.Spring.controller;
	

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RequestController {
	
	@GetMapping("/loginlink")
	public String getLoginPage(Model model) {
		return "login2";
	}
	
	@GetMapping("/succesfulLogin")
	public String successfulLogin(Model model, @AuthenticationPrincipal OAuth2User principal) {
	
		System.out.println(principal.getAttribute("name").toString());
		model.addAttribute("nombre", principal.getAttribute("name"));
		return "profile";
	}

}
