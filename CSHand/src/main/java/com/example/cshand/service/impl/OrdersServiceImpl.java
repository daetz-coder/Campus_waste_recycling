package com.example.cshand.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.cshand.entity.Orders;
import com.example.cshand.service.OrdersService;
import com.example.cshand.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

/**
* @author ASUS
* @description 针对表【orders】的数据库操作Service实现
* @createDate 2023-06-08 15:21:16
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
    implements OrdersService{

}




