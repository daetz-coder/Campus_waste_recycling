package com.example.cshand;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author daetz
 * @creat 2023/4/26
 **/
/**
@SpringBootTest
@MapperScan("com.demo.dao")
//未加MapperScan会导致空指针
public class MyBatisPlusTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testSelectList(){
		//通过构造器设计一个List集合，诺没有集合使用null参数代替
		List<User> list = userMapper.selectList(null);
		list.forEach(System.out::println); //lanbda表达式中的ff引用

	}
	@Test
	public void Test(){
		User user=new User();
		user.setId(5);
		user.setOs("1");
		user.setCpu("2");
		user.setMemory("20G");
		user.setMode("流量计费");
		user.setDuration("10年");
		user.setRegion("华北1");
		user.setBandwidth_mode("测试用例");
		int result=userMapper.insert(user);
		System.out.println("result"+result);
	}
	@Test
	public void testDelete(){
		/**
		int result = userMapper.deleteById(3);
		System.out.println("result"+result);
		 ==>  Preparing: DELETE FROM product WHERE id=?
		 ==> Parameters: 3(Integer)
		 **/
//		Map<String,Object> map =new HashMap<>();
//		map.put("region","华北1");
//		map.put("cpu","4核");
//		int result=userMapper.deleteByMap(map);
//		System.out.println("result"+result);
		//多条件设置,可以起到删除的作用
		/**
		 * 根据Map中集合的条件删除
		 * ==>  Preparing: DELETE FROM product WHERE cpu = ? AND region = ?
		 * ==> Parameters: 4核(String), 华北1(String)
		 * <==    Updates: 0
		 */
/**
		List<Integer> list=Arrays.asList(3,4);//把数据转换成集合
		int result = userMapper.deleteBatchIds(list);//idList 批量删除
		System.out.println("result"+result);
		/**
		 * ==>  Preparing: DELETE FROM product WHERE id IN ( ? , ? )
		 * ==> Parameters: 3(Integer), 4(Integer)
		 * <==    Updates: 2
		 */
/**
	}

	@Test
	public void testUpdate(){
		User user=new User();
		user.setId(1);
		user.setCpu("16核");
		userMapper.updateById(user);
		//未传入数据的字段会保持之前的数据，而不是置为null
	}


	@Test
	public void testSelect(){
		/**
		 * 根据id查询
		 */
//		User user=userMapper.selectById(1);
//		System.out.println(user);
		/**
		 * 根据id批量查询
		 */
//		List<Integer> list = Arrays.asList(1,2,3,4);
//		List<User> users =userMapper.selectBatchIds(list);
//		users.forEach(System.out::println);//lambda
/**
		Map<String,Object> map=new HashMap<>();
		map.put("region","华北1");
		map.put("cpu","2");
		List<User> users = userMapper.selectByMap(map);//ctrl+alt+v
		users.forEach(System.out::println);
	}
}
 **/