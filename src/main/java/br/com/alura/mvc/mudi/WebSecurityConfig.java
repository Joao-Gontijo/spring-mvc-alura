package br.com.alura.mvc.mudi;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
			.anyRequest() 		//qualquer request
			.authenticated() 	//tem que estar autenticado
			.and()
			.formLogin(form -> form
				.loginPage("/login")	//qual a url da página
				.defaultSuccessUrl("/home", true) //direciona para Home depois de login
				.permitAll())			//todo mundo pode acessar a página de login
			.logout(logout -> logout
				.logoutUrl("/logout"));			
	}
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		
		//criando usuário no banco de dados
//		UserDetails user =
//				User.builder()
//				.username("maria")
//				.password(encoder.encode("maria"))
//				.roles("ADM")
//				.build();
		
		auth
			.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(encoder);
//			.withUser(user);
	}

}
