package OAuth.Spring.controller;
	

import java.security.Principal;

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
	public String successfulLogin(Model model, @AuthenticationPrincipal OAuth2User oauthUser, Principal user) {
	
		String nombre;
		if ( oauthUser != null && !oauthUser.getAttributes().isEmpty()) {	
			nombre = oauthUser.getAttribute("name");
		} else {
			nombre = user.getName();
		}
		
		model.addAttribute("nombre", nombre);
		return "profile";
	}

}
