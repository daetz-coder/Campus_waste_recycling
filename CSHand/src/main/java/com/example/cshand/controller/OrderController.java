package com.example.cshand.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.cshand.DTO.ResultDataDTO;
import com.example.cshand.entity.Goods;
import com.example.cshand.entity.Orders;
import com.example.cshand.mapper.OrdersMapper;
import com.example.cshand.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author daetz
 * @creat 2023/6/8
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

		@Autowired
		private OrdersMapper ordersMapper;
		@Autowired
		private OrdersService ordersService;

		@PostMapping("/create")
		public ResultDataDTO OrderCreate(@RequestBody Orders orders){
				boolean save = ordersService.saveOrUpdate(orders);
				return ResultDataDTO.success(save);
		}

		/**
		 * 分页查询
		 * @param PageNum
		 * @param size
		 * @return
		 */
		@RequestMapping("/findAll/{PageNum}/{size}")
		public ResultDataDTO findAll(@PathVariable("PageNum") Integer PageNum, @PathVariable("size") Integer size){
				Page<Orders> page = new Page<>(PageNum, size);
				Page<Orders> result = ordersMapper.selectPage(page, null);
				return ResultDataDTO.success(result);
		}

		/**
		 * 删除订单
		 * @param id
		 */
		@DeleteMapping("/deleteById/{id}")
		public void deleteByOrderId(@PathVariable("id") Integer id){
				ordersService.removeById(id);
		}
}
