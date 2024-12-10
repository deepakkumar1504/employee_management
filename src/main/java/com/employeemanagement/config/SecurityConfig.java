package com.employeemanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

		httpSecurity
				.cors(Customizer.withDefaults())
				.csrf(customizer -> customizer.disable())
				.authorizeHttpRequests(
						request -> request.requestMatchers("/test").permitAll()
						.anyRequest().authenticated())
				//.sessionManagement(
					//	session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //
				.formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults());

		return httpSecurity.build();
	}

	@Bean
	UserDetailsService userDetailsService() {
		UserDetails deepak = User.withUsername("Deepak").password("{noop}Deepak@432").roles("USER").build();
		UserDetails nikhil = User.withUsername("Nikhil").password("{noop}Nikhil@432").roles("USER").build();
		return new InMemoryUserDetailsManager(deepak, nikhil);
	}

}
