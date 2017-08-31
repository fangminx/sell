package com.fangminx.controller;

import com.fangminx.Util.ResultVOUtil;
import com.fangminx.domain.ProductCategory;
import com.fangminx.domain.ProductInfo;
import com.fangminx.enums.ProductStatusEnum;
import com.fangminx.service.ProductCategoryService;
import com.fangminx.service.ProductService;
import com.fangminx.vo.ProductInfoVO;
import com.fangminx.vo.ProductVO;
import com.fangminx.vo.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResultVO list(){
        //查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //查询上架商品的类目编号集合
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(p->p.getCategoryType())
                .collect(Collectors.toList());

        //所有上架商品所包含的类目
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

        //遍历类目，封装商品类目视图
        List<ProductVO> productVOList = new ArrayList<>();
        productCategoryList.stream().forEach(pc->{
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            ProductVO productVO = new ProductVO();
            BeanUtils.copyProperties(pc,productVO);
            productInfoList.stream().forEach(p->{
                if(p.getCategoryType().equals(pc.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(p,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
                productVO.setProductInfoVOList(productInfoVOList);
            });
            productVOList.add(productVO);
        });
        //变量
        return ResultVOUtil.success(productVOList);
    }

}
