package com.example.cshand.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.cshand.DTO.ResultDataDTO;
import com.example.cshand.DTO.UserDTO;
import com.example.cshand.config.Constants;
import com.example.cshand.common.Result;
import com.example.cshand.entity.User;
import com.example.cshand.mapper.UserMapper;
import com.example.cshand.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author daetz
 * @creat 2023/5/2
 **/
@RestController
@RequestMapping("/user")
public class UserLoginController {

		@Autowired
		private UserService userService;

		@Autowired
		private UserMapper userMapper;

		@PostMapping("/login")
		public ResultDataDTO login(@RequestBody UserDTO userDTO) {
				String username = userDTO.getUsername();
				String password = userDTO.getPassword();
				if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
						return ResultDataDTO.error(Constants.CODE_400, "参数错误");
				}
				UserDTO dto = userService.login(userDTO);
				if(dto!=null){
						return ResultDataDTO.success(dto);
				}else{
						return ResultDataDTO.error();
				}
		}

		@PostMapping("/register")
		public ResultDataDTO register(@RequestBody User user){
				boolean save = userService.saveOrUpdate(user);
				return ResultDataDTO.success(user);
		}
		@PostMapping("/update")
		public ResultDataDTO UserUpdate(@RequestBody User user){
				boolean save = userService.saveOrUpdate(user);
				return ResultDataDTO.success(save);
		}

		@GetMapping("/findByName/{username}")
		public ResultDataDTO findByUsername(@PathVariable String username) {
				QueryWrapper<User> queryWrapper = new QueryWrapper<>();
				queryWrapper.eq("username", username);
				User user = userMapper.selectOne(queryWrapper);
				return ResultDataDTO.success(user);
		}
}
