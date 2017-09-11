package com.fangminx;

import com.fangminx.domain.ProductCategory;
import com.fangminx.domain.mapper.ProductCategoryMapper;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellApplicationTests {

	@Autowired
	private ProductCategoryMapper mapper;	//idea报错，但不影响

	@Test
	public void insertByMap() throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("categoryName","我最爱");//category_name 得和mapper里的#{}保持一致
		map.put("category_type",101);
		int result= mapper.insertByMap(map);
		Assert.assertEquals(1,result);
	}

	@Test
	public void insertByObject() throws Exception{
		ProductCategory productCategory = new ProductCategory();
		productCategory.setCategoryName("我最不爱"); //mapper的#{}必须和实体类保持一致
		productCategory.setCategoryType(102);
		int result= mapper.insertByObject(productCategory);
		Assert.assertEquals(1,result);
	}

	@Test
	public void findByCategoryType(){
		ProductCategory result = mapper.findByCategoryType(102);
		Assert.assertNotNull(result);
	}

	@Test
	public void findByCategoryName(){
		List<ProductCategory> result = mapper.findByCategoryName("我最不爱");
		Assert.assertNotEquals(0,result.size());
	}

	@Test
	public void updateByCategoryType(){
		int result = mapper.updateByCategoryType("修改了我最不爱",102);
		Assert.assertEquals(1,result);
	}

	@Test
	public void updateByObject(){
		ProductCategory productCategory = new ProductCategory();
		productCategory.setCategoryName("我最不爱");
		productCategory.setCategoryType(102);
		int result = mapper.updateByObject(productCategory);
		Assert.assertEquals(1,result);
	}

	@Test
	public void deleteByCategoryType(){
		int result = mapper.deleteByCategoryType(102);
		Assert.assertEquals(1,result);
	}

	//TODO 自动生成mybatis
}
