package com.myforum.controller.vo;

import com.myforum.dao.domain.Category;

import java.util.Date;

/**
 * Created by Administrator on 2016/12/6.
 */
public class CategoryVO {
    private String name;

    public static Category generateBy(CategoryVO categoryVO){
        Category category = new Category();
        category.setName(categoryVO.getName());
        Date date = new Date();
        category.setDateCreated(date);
        return category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
