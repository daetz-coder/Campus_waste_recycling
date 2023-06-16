package com.example.cshand;

import com.example.cshand.entity.Category;
import com.example.cshand.entity.User;
import com.example.cshand.mapper.UserMapper;
import com.example.cshand.service.CategoryService;
import com.example.cshand.service.UserService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author daetz
 * @creat 2023/4/29
 **/
@SpringBootTest
@MapperScan("com.example.cshand.mapper")
public class MyBatisPlusServiceTest {
	@Autowired
	private UserService userService;

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CategoryService categoryService;

	@Test
	public void testGetCount(){
		/**
		 * 查询总记录数
		 * SELECT COUNT( * ) FROM user
		 */
		long count = userService.count();
		System.out.println("总记录数："+count);
	}

	@Test
	public void testInsertMore(){
		List<Category> list=new ArrayList<>();
		for (int i=1;i<=10;i++){
			Category category=new Category();
			category.setName("zs"+i);
			list.add(category);
		}
		boolean b = categoryService.saveBatch(list);
		/**
		 * 批量增加数据
		 * INSERT INTO category ( name ) VALUES ( ? )
		 * saveBatch()既能修改也能添加
		 * 有id是修改，没有id是添加
		 */
		System.out.println(b);
	}

	@Test
	public void testSelectById(){
		userMapper.selectAllById(1);
	}
}
