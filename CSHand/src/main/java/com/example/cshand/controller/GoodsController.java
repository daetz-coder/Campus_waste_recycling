package com.example.cshand.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.cshand.DTO.ResultDataDTO;
import com.example.cshand.config.Constants;
import com.example.cshand.entity.Cart;
import com.example.cshand.entity.Goods;
import com.example.cshand.entity.User;
import com.example.cshand.mapper.GoodsMapper;
import com.example.cshand.service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author daetz
 * @creat 2023/6/8
 **/
@RestController
@RequestMapping("/goods")
public class GoodsController {

		@Autowired
		private GoodsMapper goodsMapper;

		@Autowired
		private GoodsServiceImpl goodsService;


		@PutMapping("/{productId}")
		public ResultDataDTO updateProductState(
						@PathVariable("productId") Integer productId) {

				// 根据 productId 获取商品对象
				Goods product = goodsMapper.selectById(productId);
				if (product.getState() == 1) {
						product.setState(0);
						boolean result = goodsService.saveOrUpdate(product);
						return ResultDataDTO.success(result);
				} else if (product.getState() == 0) {
						product.setState(1);
						boolean result = goodsService.saveOrUpdate(product);
						return ResultDataDTO.success(result);
				}else {
						return ResultDataDTO.error("500","未知错误");
				}
		}





		/**
		 * 根据category查询+分页
		 * @param PageNum
		 * @param size
		 * @param categoryId
		 * @return
		 */
		@RequestMapping("/findByCategory/{PageNum}/{size}/{categoryId}")
		public ResultDataDTO findGoods(
						@PathVariable("PageNum") Integer PageNum,
						@PathVariable("size") Integer size,
						@PathVariable("categoryId") Integer categoryId
		){
						Page<Goods> page = new Page<>(PageNum, size);
						// 创建查询条件对象
						QueryWrapper<Goods> queryWrapper = new QueryWrapper<>();
						queryWrapper.eq("category_id", categoryId); // 根据categoryId进行条件查询

						Page<Goods> result = goodsMapper.selectPage(page, queryWrapper);
						return ResultDataDTO.success(result);
		}

		/**
		 * 商品详情展示
		 * @param id
		 * @return
		 */
		@RequestMapping("/findById/{id}")
		public ResultDataDTO findById(@PathVariable Integer id){
				Goods result = goodsService.getById(id);
				return ResultDataDTO.success(result);
		}


		/**
		 * 商品分页查询
		 * @param PageNum
		 * @param size
		 * @return
		 */
		@RequestMapping("/findAll/{PageNum}/{size}")
		public ResultDataDTO findAll(@PathVariable("PageNum") Integer PageNum, @PathVariable("size") Integer size){
				Page<Goods> page = new Page<>(PageNum, size);
				Page<Goods> result = goodsMapper.selectPage(page, null);
				return ResultDataDTO.success(result);
		}

		@RequestMapping("/saveOrUpdate")
		public ResultDataDTO SaveGoods(@RequestBody Goods goods){
				boolean save = goodsService.saveOrUpdate(goods);
				return ResultDataDTO.success(save);
		}


		/**
		 * 根据id删除
		 * @param id
		 */
		@DeleteMapping("/deleteByGoodsId/{id}")
		public void deleteByGoodsId(@PathVariable("id") Integer id){
				goodsService.removeById(id);
		}
}
