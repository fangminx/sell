package com.fangminx.domain.mapper;

import com.fangminx.domain.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface ProductCategoryMapper {

    @Insert("insert into product_category(category_name,category_type) values(#{categoryName, jdbcType=VARCHAR},#{category_type, jdbcType=INTEGER})")
    int insertByMap(Map<String,Object> map);

    @Insert("insert into product_category(category_name,category_type) values(#{categoryName, jdbcType=VARCHAR},#{categoryType, jdbcType=INTEGER})")
    int insertByObject(ProductCategory productCategory);

    @Select("select * from product_category where category_type= #{categoryType}")
    //这样才能把字段映射到对象
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_type", property = "categoryType")
    })
    ProductCategory findByCategoryType(Integer categoryType);

    @Select("select * from product_category where category_name= #{categoryName}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "category_type", property = "categoryType")
    })
    List<ProductCategory> findByCategoryName(String categoryName);

    //多个参数要用@Parm注解
    @Update("update product_category set category_name = #{categoryName} where category_type= #{categoryType}")
    int updateByCategoryType(@Param("categoryName") String categoryName,
                             @Param("categoryType")Integer categoryType);

    @Update("update product_category set category_name = #{categoryName} where category_type= #{categoryType}")
    int updateByObject(ProductCategory productCategory);

    @Delete("delete from product_category where category_type= #{categoryType}")
    int deleteByCategoryType(Integer categoryType);
}
