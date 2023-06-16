package com.example.cshand.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.cshand.DTO.UserDTO;
import com.example.cshand.config.Constants;
import com.example.cshand.entity.User;
import com.example.cshand.exception.ServiceException;
import com.example.cshand.service.UserService;
import com.example.cshand.mapper.UserMapper;
import com.example.cshand.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
* @author ASUS
* @description 针对表【user(用户表)】的数据库操作Service实现
* @createDate 2023-06-08 19:30:11
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{


		private static final Log LOG = Log.get();

		@Autowired
		HttpServletResponse response;

		@Override
		public UserDTO login(UserDTO userDTO) {
				// 用户密码 md5加密
				//userDTO.setPassword(SecureUtil.md5(userDTO.getPassword()));
				User one = getUserInfo(userDTO);
				if (one != null) {
						BeanUtil.copyProperties(one, userDTO, true);
						// 设置token
						String token = TokenUtils.genToken(one.getId().toString(), one.getPassword());
						userDTO.setToken(token);
						return userDTO;
				} else {
						return null;
				}
		}

		private User getUserInfo(UserDTO userDTO) {
				QueryWrapper<User> queryWrapper = new QueryWrapper<>();
				queryWrapper.eq("username", userDTO.getUsername());
				queryWrapper.eq("password", userDTO.getPassword());
				User one;
				try {
						one = getOne(queryWrapper); // 从数据库查询用户信息
				} catch (Exception e) {
						LOG.error(e);
						throw new ServiceException(Constants.CODE_500, "系统错误");
				}
				return one;
		}

}




