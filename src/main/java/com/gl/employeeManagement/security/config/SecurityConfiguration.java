package com.gl.employeeManagement.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.*;

import com.gl.employeeManagement.service.MyUserDetailsService;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	MyUserDetailsService service;

	@Bean
	PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(service).passwordEncoder(getPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/h2-console/**").permitAll().antMatchers(HttpMethod.GET, "/employees")
				.permitAll().antMatchers(HttpMethod.GET, "/employees/{employeeId}").permitAll()
				.antMatchers(HttpMethod.POST, "/employees").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.PUT, "/employees/{employeeId}").hasAuthority("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/employees/{employeeId}").hasAuthority("ADMIN").and().httpBasic().and()
				.csrf().disable();

	}

}
