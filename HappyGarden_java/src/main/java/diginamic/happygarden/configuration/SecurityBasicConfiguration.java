package diginamic.happygarden.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityBasicConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private SecurityUserService securityUserServ;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/Admin/**").hasRole("ADMIN")
			.antMatchers("/Plant", "/UserRole/**").permitAll()
			.antMatchers(HttpMethod.POST, "/UserAccount").permitAll()
			.anyRequest().authenticated()
			.and().formLogin().successHandler(successHandler()).failureHandler(failureHandler()).and().logout().permitAll()
			.and().httpBasic()
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
			.and().cors()
//			.and().csrf()
//			.csrfTokenRepository(CookieCsrfTokenRepository
//				.withHttpOnlyFalse())
			.and().csrf().disable();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) throws Exception {
		auth.userDetailsService(securityUserServ).passwordEncoder(passwordEncoder);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}
	
//	@Bean
//	public CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//		configuration.setAllowedMethods(Arrays.asList( "GET","POST","PUT","DELETE"));
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/", configuration);
//		return source;
//	}
	
	@Bean
	public WebMvcConfigurer configurer(){
	  return new WebMvcConfigurer(){
	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	      registry.addMapping("/**")
	      	  .allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE", "OPTIONS")
	          .allowedOrigins("http://localhost:4200").allowCredentials(true);
	    }
	  };
	}
	
	public AuthenticationSuccessHandler successHandler() {
		return new AuthenticationSuccessHandler() {
			
			@Override
			public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
					Authentication authentication) throws IOException, ServletException {
				response.setStatus(HttpServletResponse.SC_OK);
			}
		};
	}
	
	public AuthenticationFailureHandler failureHandler() {
		return new AuthenticationFailureHandler() {
			
			@Override
			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
					AuthenticationException exception) throws IOException, ServletException {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
		};
	}
}
