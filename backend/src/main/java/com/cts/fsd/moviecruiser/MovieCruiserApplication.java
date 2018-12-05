package com.cts.fsd.moviecruiser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.cts.fsd.moviecruiser.filter.JwtFilter;
/**
 * @author Adarsh
 *App launcher for movie cruiser
 */
@SpringBootApplication
public class MovieCruiserApplication {

	/**
	 * Main method for app launcher
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(MovieCruiserApplication.class, args);
	}
	@SuppressWarnings("unchecked")
	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/*");
		return registrationBean;
	}
}
