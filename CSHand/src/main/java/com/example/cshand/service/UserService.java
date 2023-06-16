package com.example.cshand.service;

import com.example.cshand.DTO.UserDTO;
import com.example.cshand.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author ASUS
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2023-06-08 19:30:11
*/
public interface UserService extends IService<User> {
		public UserDTO login(UserDTO userDTO);
}
