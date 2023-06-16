package com.example.cshand.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.cshand.entity.Address;
import com.example.cshand.service.AddressService;
import com.example.cshand.mapper.AddressMapper;
import org.springframework.stereotype.Service;

/**
* @author ASUS
* @description 针对表【address】的数据库操作Service实现
* @createDate 2023-06-08 10:09:32
*/
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address>
    implements AddressService{

}




