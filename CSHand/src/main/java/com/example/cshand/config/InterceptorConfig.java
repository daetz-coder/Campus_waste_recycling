package com.example.cshand.config;

import com.example.cshand.common.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author daetz
 * @creat 2023/5/3
 **/

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

		@Override
		public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(jwtInterceptor())
								.addPathPatterns("/**")    // 拦截所有请求，通过判断token 决定是否需要登录
								.excludePathPatterns("/user/login","/user/register","**/user");
		}

		@Bean
		public JwtInterceptor jwtInterceptor(){
				return new JwtInterceptor();
		}
}
