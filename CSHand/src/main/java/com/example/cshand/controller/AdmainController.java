package com.example.cshand.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.cshand.entity.Category;
import com.example.cshand.entity.Goods;
import com.example.cshand.entity.Product;
import com.example.cshand.entity.User;
import com.example.cshand.mapper.UserMapper;
import com.example.cshand.service.CategoryService;
import com.example.cshand.service.GoodsService;
import com.example.cshand.service.ProductService;
import com.example.cshand.service.UserService;
import com.example.cshand.util.TokenUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;
import java.util.List;
import java.io.File;

/**
 * @author daetz
 * @creat 2023/4/27
 **/
@RestController
public class AdmainController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserMapper userMapper;

	@RequestMapping("/findCategory")
	public List<Category> findCategory(){
		return categoryService.list();
	}
	@RequestMapping("/findGoods")
	public List<Goods> findGoods(){
		return goodsService.list();
	}
	@RequestMapping("/findProduct")
	public List<Product> findProduct(){
		return productService.list();
	}
	@RequestMapping("/findUser")
	public List<User> findUser(){
		return userService.list();
	}

	@RequestMapping("/findUser/{PageNum}/{size}")
	public Page<User> findPage(@PathVariable("PageNum") Integer PageNum,@PathVariable("size") Integer size){
			Page<User> page =new Page<>(PageNum,size);
			return userMapper.selectPage(page,null);
	}

		@PostMapping("/token")
		public User Token(@RequestHeader("token") String token, HttpServletRequest request) {
				User currentUser = TokenUtils.getCurrentUser(request);
				System.out.println(currentUser.getNickname());
				return currentUser;
		}

}
