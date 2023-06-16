package com.example.cshand;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.cshand.entity.User;
import com.example.cshand.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author daetz
 * @creat 2023/4/30
 **/
@SpringBootTest
@MapperScan("com.example.cshand.mapper")
public class MybatisPlusPluginsTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testPage(){
		Page<User> page =new Page<>(1,1);
		userMapper.selectPage(page,null);
		System.out.println(page);
	}
}
