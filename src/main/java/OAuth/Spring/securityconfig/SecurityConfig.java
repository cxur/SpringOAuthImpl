package OAuth.Spring.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomOAuthUserService customOAuthUserService;

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	private OAuthSuccessHandler oAuthSuccessHandler;

	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//		authenticationManagerBuilder.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
//	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	    
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf()
        .disable()
    .formLogin().loginPage("/loginlink").loginProcessingUrl("/processLogin").successHandler(oAuthSuccessHandler).and()
    .httpBasic().disable().authorizeRequests(a -> a
                .antMatchers("/loginlink","/h2-console/**").permitAll()
                .anyRequest().authenticated()
            ).
		oauth2Login() 
		.loginPage("/loginlink")
				.redirectionEndpoint()
                .baseUri("/authorize/callback/*").
				and().userInfoEndpoint().userService(customOAuthUserService).
				and().
				successHandler(oAuthSuccessHandler);
		
		http.headers().frameOptions().disable();
	}
	
	


}
