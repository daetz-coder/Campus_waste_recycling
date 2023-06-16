package com.example.cshand.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.cshand.DTO.ResultDataDTO;
import com.example.cshand.entity.Cart;
import com.example.cshand.entity.User;
import com.example.cshand.mapper.CartMapper;
import com.example.cshand.service.impl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author daetz
 * @creat 2023/6/8
 **/
@RestController
@RequestMapping("/cart")
public class CartController {


		@Autowired
		private CartMapper cartMapper;

		@Autowired
		private CartServiceImpl cartService;

		/**
		 * 加入购物车
		 * @param cart
		 * @return
		 */
		@PostMapping("/saveOrUpdate")
		public ResultDataDTO SaveCart(@RequestBody Cart cart){
				boolean save = cartService.saveOrUpdate(cart);
				return ResultDataDTO.success(save);
		}


		/**
		 * 购物订单展示
		 * @return
		 */
		@RequestMapping("/findCart")
		public ResultDataDTO findCart(){
				List<Cart> list = cartService.list();
				return ResultDataDTO.success(list);
		}

		@RequestMapping("/deleteById/{id}")
		public ResultDataDTO deleteById(@PathVariable Integer id){
				boolean result = cartService.removeById(id);
				return ResultDataDTO.success(result);
		}
}
