package com.example.cshand.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.cshand.entity.Cart;
import com.example.cshand.service.CartService;
import com.example.cshand.mapper.CartMapper;
import org.springframework.stereotype.Service;

/**
* @author ASUS
* @description 针对表【cart】的数据库操作Service实现
* @createDate 2023-06-08 14:29:53
*/
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart>
    implements CartService{

}




