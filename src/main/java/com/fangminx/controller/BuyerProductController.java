package com.fangminx.controller;

import com.fangminx.enums.ProductStatusEnum;
import com.fangminx.vo.ProductInfoVO;
import com.fangminx.vo.ProductVO;
import com.fangminx.vo.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @GetMapping("/list")
    public ResultVO list(){
        ResultVO<ProductVO> res = new ResultVO();
        res.setCode(ProductStatusEnum.up.getCode());
        res.setMsg("成功");
        ProductVO pv = new ProductVO();
        pv.setCategoryName("categoryName");
        pv.setCategoryType(1);
        List<ProductInfoVO> ls = new ArrayList<>();
        pv.setProductInfoVOList(ls);
        res.setData(pv);
        return res;
    }

}
