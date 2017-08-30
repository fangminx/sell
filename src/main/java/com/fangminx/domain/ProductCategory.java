package com.fangminx.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@DynamicUpdate  //当更新了该实体类时才会并且一定会更新对应时间
@Entity
public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer c;     //

    private String categoryName;    //类目名字

    private Integer categoryType;   //类目编号

    private Date createTime;

    private Date updateTime;

    public ProductCategory(String categoryName,Integer categoryType){
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
