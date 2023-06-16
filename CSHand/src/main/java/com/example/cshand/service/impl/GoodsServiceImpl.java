package com.example.cshand.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.cshand.entity.Goods;
import com.example.cshand.service.GoodsService;
import com.example.cshand.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

/**
* @author ASUS
* @description 针对表【goods(商品表)】的数据库操作Service实现
* @createDate 2023-06-09 15:33:40
*/
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>
    implements GoodsService{

}




