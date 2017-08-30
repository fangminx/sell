package com.fangminx.service;

import com.fangminx.domain.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

//注意，在实现里加@Service注解
public interface ProductCategoryService {

    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    ProductCategory save(ProductCategory productCategory);
}
