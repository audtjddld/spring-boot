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
			.headers()
				.xssProtection()
					.block(true);	// xss 취약점 방어 
		/*
		    Content Security Policy 도 사용할 수 있음 상세 내용은 아래 확인.
		    
			Content Security Policy (CSP) 는 Cross Site Scripting (XSS)와 data injection 같은 공격을 감지하거나 경감시키기 위해서 보안층을 추가하는 것입니다. 이런류의 공격은 정보를 갈취하거나 멀웨어(malware)를 유포시키려는 등의 모든 목적들을 위해서 이용됩니다. 
			
			CSP 는 하위호환성에 중점을 둬서 디자인되어 이것을 지원하는 서버에 지원하지 않는 브라우져가 잘 작동되고 그 반대도 가능합니다. CSP를 지원하지 않는 브라우저는 CSP를 무시하고, 단순히 웹 콘텐츠에 대한 표준 same-origin 정책을 기본값으로 해서 평소대로 작동합니다. 웹 사이트가 CSP헤더를 제공하지 않으면 마찬가지로 브라우저들은 same-origin policy 표준을 사용합니다.
			
			CSP는 웹서버에 Content-Security-Policy HTTP를 설정하는 것 만큼 쉽게 설정할 수 있습니다. (Firefox 23 이전에는 Content-Security-Policy를 사용했습니다). Using Content Security Policy 를 찾아보면 어떻게 설정하는지와 CSP를 활성화 시키는지 자세히 설명되어 있습니다.
			
	http
	// ...
	.headers()
		.addHeaderWriter(new StaticHeadersWriter("X-Content-Security-Policy","default-src 'self'"))
		.addHeaderWriter(new StaticHeadersWriter("X-WebKit-CSP","default-src 'self'"));			
		 */
		
		http.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/member/**").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.and()
			.logout()
				.permitAll()
				
				;
		
			
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
			auth
				.inMemoryAuthentication()
					.withUser("user").password("password").roles("USER");
	}
}
