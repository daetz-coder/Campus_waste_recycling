package com.example.cshand.common;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.cshand.entity.User;
import com.example.cshand.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtInterceptor implements HandlerInterceptor {

		@Autowired
		private UserService userService;

		@Override
		public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
				String token = request.getHeader("token");
				// 如果不是映射到方法直接通过
				if (!(handler instanceof HandlerMethod)) {
						return true;
				}
				if (StrUtil.isBlank(token)) {
						response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "无token，请重新登录");
						return false;
				}
				String userId;
				try {
						userId = JWT.decode(token).getAudience().get(0);
				} catch (JWTDecodeException j) {
						response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "token验证失败");
						return false;
				}
				//根据userId查询
				User user = userService.getById(userId);
				if (user == null) {
						response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "用户不存在，请重新登录");
						return false;
				}
				//用户密码加签名验证
				JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
				try {
						jwtVerifier.verify(token);
				} catch (JWTVerificationException e) {
						response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "401");
						return false;
				}
				return true;
		}
}
