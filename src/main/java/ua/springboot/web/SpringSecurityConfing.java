package ua.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfing extends WebSecurityConfigurerAdapter{

	@Autowired 
	UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(this.userDetailsService)
			.passwordEncoder(passwordEncoder());
	}

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.formLogin()
			.loginPage("/")
			.usernameParameter("email")
			.passwordParameter("password")
			.failureUrl("/?fail=true")
		.and()
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID", "RememberMeCookie")
			
		.and()
			.authorizeRequests()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/user/**").hasAnyRole("ADMIN","CLIENT")
			.anyRequest().permitAll()
		.and()
			.exceptionHandling().accessDeniedPage("/")
		.and()
			.sessionManagement().maximumSessions(1)
		.and().and()
			.rememberMe()
			.rememberMeParameter("remember-me")
			.key("secret key")
			.rememberMeCookieName("RememberMeCookie")
			.tokenValiditySeconds(7*24*60*60)
		.and()
			.csrf().disable();
		
	
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("resources/**");
	}
	
	
}
