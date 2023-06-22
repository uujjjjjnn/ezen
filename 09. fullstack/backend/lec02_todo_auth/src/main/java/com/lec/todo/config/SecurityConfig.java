package com.lec.todo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CorsFilter;

import com.lec.todo.security.JwtAuthencationFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private JwtAuthencationFilter jwtAuthencationFilter;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// http ��ť��Ƽ ����
		http.cors().and()			// WebMvcConfig���� �����߱� ������ �⺻ cors�� ���� (���� �������� http.cors("http://localhost:3000") )
			.csrf().disable() 		// csrf ��ŷ����, ���� ������� �ʱ� ������ disable
			.httpBasic().disable() 	// token�� ����ϱ� ������ basic ������ disable
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) 	// session����� �ƴ��� ����
			.and()
			.authorizeRequests().antMatchers("/", "/auth/**").permitAll() 	// root(/), /auth/** ��δ� ������ ���
			.anyRequest().authenticated();
			
		// filter�� ���
		// �� ��û���� Corsfilter ������ �Ŀ� jwtAuthenticationFilter�� ����
		http.addFilterAfter(jwtAuthencationFilter, CorsFilter.class);
		
		return http.build();
	}
	
}
