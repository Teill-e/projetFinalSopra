package projetArmee.projetArmeeBack.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.antMatcher("/api/**")
				.csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.authorizeRequests()
					.antMatchers(HttpMethod.OPTIONS).permitAll()
					.antMatchers(HttpMethod.GET,"/api/compte/login/**").anonymous()
					.antMatchers(HttpMethod.POST,"/api/compte/inscription").anonymous()
//					.antMatchers(HttpMethod.GET,"/api/auth").authenticated()
//					.antMatchers("/api/joueur").hasAnyRole("JOUEUR","ADMIN")
//					.antMatchers("/api/**").hasAnyRole("ADMIN")
					.anyRequest().permitAll()
				.and()
				.httpBasic()
				.and()
				.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
