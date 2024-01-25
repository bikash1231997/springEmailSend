package com.example.RestApi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable()).authorizeHttpRequests(request -> request.requestMatchers(new AntPathRequestMatcher("/send/**")).permitAll()
				.anyRequest().authenticated());

//		http.csrf().disable().cors().disable();
//		http.csrf().disable().authorizeRequests().requestMatchers("/**").permitAll();
		return http.build();
	}

}
