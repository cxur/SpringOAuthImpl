package OAuth.Spring.securityconfig;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class OAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("HOLAAAAAAAA222222");
		/*
		 * Cookie[] cookiesRequestData = request.getCookies(); for (Cookie cookie :
		 * cookiesRequestData) { System.out.println(cookie.getName()); if
		 * (cookie.getName().equals("redirect_uri")) { redirectURI =
		 * UriComponentsBuilder.fromUriString(cookie.getValue()) .build().toUriString();
		 * 
		 * 
		 * } }
		 */
		
		System.out.println();
		String redirectURI = UriComponentsBuilder.fromUriString(request.getRequestURI()) .build().toUriString();
		System.out.println(redirectURI);
		clearAuthenticationAttributes(request, response);
		getRedirectStrategy().sendRedirect(request, response, "/succesfulLogin");
	}
	
	 protected void clearAuthenticationAttributes(HttpServletRequest request, HttpServletResponse response) {
	        super.clearAuthenticationAttributes(request);
	        
	    }

}
