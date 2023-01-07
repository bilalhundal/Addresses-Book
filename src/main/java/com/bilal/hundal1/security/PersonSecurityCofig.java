package com.bilal.hundal1.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import com.bilal.hundal1.services.JpaUserDetailsService;
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class PersonSecurityCofig{
	JpaUserDetailsService jpaUserDetailsService;
	public PersonSecurityCofig(JpaUserDetailsService paUserDetailsService) {
		this.jpaUserDetailsService=paUserDetailsService;
	}
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.csrf().disable()
            .authorizeHttpRequests((authz) -> authz.requestMatchers("/h2-console/**","/hello").permitAll()
               .anyRequest().authenticated()
            ).userDetailsService(jpaUserDetailsService).headers(header->header.frameOptions().sameOrigin())
            .formLogin().defaultSuccessUrl("/").and().
          build();
    }
	 @Bean
	 JdbcUserDetailsManager users(DataSource dataSource) {
		 JdbcUserDetailsManager jdbcUserDetailsManager=new JdbcUserDetailsManager(dataSource);
		 return jdbcUserDetailsManager;
	 }
	 @Bean
	 PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	 }
}



























