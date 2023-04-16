package com.mohit.learning.learning.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.mohit.learning.learning.utils.JwtRequestFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	JwtRequestFilter jwtRequestFilter;

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.inMemoryAuthentication().withUser("mohit").password("mohit").roles("USER").and().withUser("rohit")
//				.password("rohit").roles("ADMIN");
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/user/**")
//				.hasAnyRole("USER", "ADMIN").and().formLogin();
//
//	}
//
	@Bean
	public PasswordEncoder getPasswordEncoder() {

		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable().authorizeRequests().antMatchers("/user/authenticate", "/v3/**", "/**")
				.permitAll().anyRequest().authenticated().and().exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	}

//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/public/**", "/v2/api-docs", "/v3/api-docs", "/configuration/ui", "/swagger-resources/**",
//				"/swagger-ui.html");
//	}

}
