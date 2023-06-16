package com.example.cshand.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author daetz
 * @creat 2023/4/27
 **/
@Configuration
public class CrossConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
						.allowCredentials(false)
						.maxAge(3600)
						.allowedHeaders("*");
	}
}
