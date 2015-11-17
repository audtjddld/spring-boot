package com.devms.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	/**
		The WebSecurityConfig class is annotated with @EnableWebMvcSecurity to enable 
		Spring Security’s web security support and provide the Spring MVC integration.
		It also extends WebSecurityConfigurerAdapter and overrides a couple of its methods
		to set some specifics of the web security configuration.
		
		 WebSecurityConfig class 는 @@EnableWebMvcSecurity 으로 
		 Spring Security 의 웹 보안은  Spring MVC 통합적으로 가능하도록 지원해준다. 
		 
		 또한, WebSecurityConfigurerAdapter 상속하여 두개의 메서드를 오버라이드하여 
		 스프링 시큐리티를 몇가지 설정을 할 수 있다.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		http
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/member/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
		
			
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
			auth
				.inMemoryAuthentication()
					.withUser("user").password("password").roles("USER");
	}
}
