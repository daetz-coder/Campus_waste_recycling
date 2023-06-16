package com.example.cshand.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author daetz
 * @creat 2023/4/30
 **/
@Configuration
@MapperScan("com.example.cshand.dao")
public class MybatisPlusConfig {
	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor(){
		MybatisPlusInterceptor interceptor=new MybatisPlusInterceptor();
		interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
		return interceptor;
	}
}
