package com.example.cshand.DTO;

import lombok.Data;

import java.security.SecureRandom;

/**
 * @author daetz
 * @creat 2023/5/2
 **/

/**
 * 接收前端登录请求参数
 */
@Data
public class UserDTO {
		private String username;
		private String password;
		private String token;
		private String role;
		private String avatar;
}
