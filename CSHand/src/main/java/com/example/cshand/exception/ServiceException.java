package com.example.cshand.exception;
import lombok.Getter;

/**
 * @author daetz
 * @creat 2023/5/31
 **/
@Getter
public class ServiceException extends RuntimeException{
		private String code;

		public ServiceException(String code, String msg) {
				super(msg);
				this.code = code;
		}
}
