package com.myforum.service;

import com.myforum.dao.domain.Category;

import java.util.List;

/**
 * Created by Administrator on 2016/12/6.
 */
public interface CategoryService {
    boolean addCategory(Category category);

    List<Category> allCategory();
}
