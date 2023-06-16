package com.example.cshand.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.cshand.entity.Category;
import com.example.cshand.service.CategoryService;
import com.example.cshand.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author ASUS
* @description 针对表【category(类别表)】的数据库操作Service实现
* @createDate 2023-06-08 14:29:53
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

}




