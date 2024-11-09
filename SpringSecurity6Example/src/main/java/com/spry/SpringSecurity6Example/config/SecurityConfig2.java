package com.spry.SpringSecurity6Example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.spry.SpringSecurity6Example.service.MyUserDetailsService;

//@Configuration
//@EnableWebSecurity // does not use default security use that class security
public class SecurityConfig2 {
	
	@Autowired
	private MyUserDetailsService userDetailsService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//		http.csrf(customizer -> customizer.disable());
//		http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
//		// http.formLogin(Customizer.withDefaults()); // we use default loggin page of spring boot
//		http.httpBasic(Customizer.withDefaults()); // we can chek in postman also give pop up for chek in broser to add password and username
//		http.sessionManagement(session -> 
//		session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));  //it get every time new session id in post man 

		// in shortcut of top of line

//		Customizer<CsrfConfigurer<HttpSecurity>> custCsrf = new Customizer<CsrfConfigurer<HttpSecurity>>() {
//
//			@Override
//			public void customize(CsrfConfigurer<HttpSecurity> customizer) {
//				customizer.disable();
//			}
//		};   is a lambda fuction so we can write in shortcut

//		http.csrf(custCsrf);

		// final code
		return http.csrf(customizer -> customizer.disable())
				.authorizeHttpRequests(request -> request.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();

//		return http.build();
	}
	
	
//	@Bean
//	public UserDetailsService userDetailsService() {  // UserDetailsService is a interface
//		
//		UserDetails user1=User
//				.withDefaultPasswordEncoder()
//				.username("sahil")
//				.password("sahil")
//				.roles("USER")
//				.build();
//		
//		UserDetails user2=User
//				.withDefaultPasswordEncoder()
//				.username("jafar")
//				.password("jafar")
//				.roles("ADMIN")
//				.build();
//		
//		return new InMemoryUserDetailsManager(user1,user2);  //InMemoryUserDetailsManager is a class
//	}
	
	//create on authethication provider
	
	@Bean
	public AuthenticationProvider authenticationProvider() { //AuthenticationProvider  is interface
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();  //is implemented class of AuthenticationProvider that
	
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}

}
