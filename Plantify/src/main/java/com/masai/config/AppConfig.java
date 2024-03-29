package com.masai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class AppConfig {

	@Bean
	public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception {
//		.requestMatchers(HttpMethod.GET,"/customers").hasRole("ADMIN")
//		http
//		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//		.and()
//		.csrf().disable()
//		.authorizeHttpRequests()
//		.requestMatchers(HttpMethod.POST, "/customers")
//		.permitAll()
//		.requestMatchers("/items/name/**", "/items/category**", "/items/restaurant/**","/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**", "/webjars/**").permitAll()
//		.requestMatchers(HttpMethod.GET,"/customers/**").hasAnyRole("ADMIN","USER")
//		.anyRequest()
//		.authenticated()
//		.and()
//		.formLogin()
//		.and()
//		.httpBasic();
		
		http
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers(HttpMethod.POST, "/customer/registercustomer")
		.permitAll()
		.requestMatchers("/items/name/**", "/items/category**", "/items/restaurant/**","/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**", "/webjars/**").permitAll()
//		.requestMatchers(HttpMethod.GET,"/customers").hasRole("ADMIN")
//		.requestMatchers(HttpMethod.GET,"/customers/**").hasAnyRole("ADMIN","USER")
		.anyRequest()
		.authenticated()
		.and()
//		.addFilterAfter(new JwtTokenGeneratorFilter(), BasicAuthenticationFilter.class)
//		.addFilterBefore(new JwtTokenValidatorFilter(), BasicAuthenticationFilter.class)
		.formLogin()
		.and()
		.httpBasic();

		return http.build();

	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();

	}

}
