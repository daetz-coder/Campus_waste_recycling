package com.example.cshand.DTO;

import com.example.cshand.config.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author daetz
 * @creat 2023/5/5
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultDataDTO implements Serializable {
		private String code;
		private String message;
		private Object data;
		private long timestamp;
		public static ResultDataDTO success(){
				return new ResultDataDTO(Constants.CODE_200,"请求成功",null, System.currentTimeMillis());
		}
		public static ResultDataDTO success(Object data){
				return new ResultDataDTO(Constants.CODE_200,"请求成功",data,System.currentTimeMillis());
		}
		public static ResultDataDTO error(String code,String msg){
				return new ResultDataDTO(code,msg,null,System.currentTimeMillis());
		}
		public static ResultDataDTO error(){
				return new ResultDataDTO(Constants.CODE_500,"系统错误",null,System.currentTimeMillis());
		}
		public static ResultDataDTO unauthorized() {
				return new ResultDataDTO(Constants.CODE_401, "未授权访问", null, System.currentTimeMillis());
		}

		public static ResultDataDTO badRequest(String msg) {
				return new ResultDataDTO(Constants.CODE_400, msg, null, System.currentTimeMillis());
		}
}
