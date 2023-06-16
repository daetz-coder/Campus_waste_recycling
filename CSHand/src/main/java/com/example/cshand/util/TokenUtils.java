package com.example.cshand.util;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.cshand.entity.User;
import com.example.cshand.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

/**
 * @author daetz
 * @creat 2023/5/3
 **/
@Component
public class TokenUtils {
		private static UserService staticUserService;

		@Resource
		private  UserService userService;

		@PostConstruct
		public void setStaticUserService(){
				staticUserService=userService;
		}
		public static String genToken(String userId,String sign){
				return JWT.create().withAudience(userId) // 将 user id 保存到 token 里面,作为载荷
								.withExpiresAt(DateUtil.offsetHour(new Date(),2000))
								.sign(Algorithm.HMAC256(sign)); // 以 password 作为 token 的密钥

		}


public static User getCurrentUser(HttpServletRequest request) {
		try {
				String token = request.getHeader("token");
				if (StrUtil.isNotBlank(token)) {
						String userId = JWT.decode(token).getAudience().get(0);
						return staticUserService.getById(userId);
				}
		} catch (Exception e) {
				return null;
		}
		return null;
}

}
