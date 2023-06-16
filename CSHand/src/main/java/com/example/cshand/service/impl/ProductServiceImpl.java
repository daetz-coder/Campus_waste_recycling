package com.example.cshand.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.cshand.entity.Product;
import com.example.cshand.service.ProductService;
import com.example.cshand.mapper.ProductMapper;
import org.springframework.stereotype.Service;

/**
* @author ASUS
* @description 针对表【product(订单表)】的数据库操作Service实现
* @createDate 2023-06-08 14:29:53
*/
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product>
    implements ProductService{

}




