package com.example.cshand.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.cshand.DTO.ResultDataDTO;
import com.example.cshand.entity.Category;
import com.example.cshand.entity.User;
import com.example.cshand.mapper.UserMapper;
import com.example.cshand.service.CategoryService;
import com.example.cshand.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author daetz
 * @creat 2023/5/1
 **/

@RestController
@RequestMapping("/admin")
public class AdminAddController {
		@Autowired
		private UserService userService;

		@Autowired
		private CategoryService categoryService;
		@PostMapping("/save")
		public Boolean save(@RequestBody User user){
				boolean save = userService.save(user);
				return save;
		}

		@PostMapping("/update")
		public Boolean update(@RequestBody User user){
				boolean save = userService.saveOrUpdate(user);
				return save;
		}

		@GetMapping("/findById/{id}")
		public User findById(@PathVariable("id") Integer id){
			return userService.getById(id);
		}

		@DeleteMapping("/delete/{id}")
		public void deleteById(@PathVariable("id") Integer id){
				userService.removeById(id);
		}

		@GetMapping("/findByName/{username}")
		public List<User> findByName(@PathVariable String username){
				return userService.list(new QueryWrapper<User>().lambda().eq(User::getUsername, username));
		}

		@GetMapping("/findCategory")
		public ResultDataDTO findByName(){
				List<Category> list = categoryService.list();
				return ResultDataDTO.success(list);
		}

		@DeleteMapping("/deleteByCategory/{id}")
		public void deleteByCategoryId(@PathVariable("id") Integer id){
				userService.removeById(id);
		}
}
