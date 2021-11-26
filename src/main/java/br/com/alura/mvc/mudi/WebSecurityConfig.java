package br.com.alura.mvc.mudi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
			.anyRequest() 		//qualquer request
			.authenticated() 	//tem que estar autenticado
			.and()
			.formLogin(form -> form
				.loginPage("/login") 	//qual a url da página
				.permitAll())			//todo mundo pode acessar a página de login
			.logout(logout -> logout
				.logoutUrl("/logout"));			
	}
	
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
				User.withDefaultPasswordEncoder()
				.username("joao")
				.password("joao")
				.roles("ADM")
				.build();
		return new InMemoryUserDetailsManager(user);
	}
}
