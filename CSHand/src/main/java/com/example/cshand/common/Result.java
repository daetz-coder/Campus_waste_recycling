package com.example.cshand.common;

import com.example.cshand.config.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author daetz
 * @creat 2023/5/3
 * 统一接口返回类
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
		private String code;
		private String message;
		private Object data;

		public static Result success(){
				return new Result(Constants.CODE_200,"",null);
		}
		public static Result success(Object data){
				return new Result(Constants.CODE_200,"",data);
		}
		public static Result error(String code,String msg){
				return new Result(code,msg,null);
		}
		public static Result error(){
				return new Result(Constants.CODE_500,"系统错误",null);
		}
}
