package com.myforum.service.impl;

import com.myforum.dao.domain.Category;
import com.myforum.dao.repositories.CategoryRepository;
import com.myforum.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/12/6.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean addCategory(Category category) {
        return categoryRepository.saveAndFlush(category) != null;
    }

    @Override
    public List<Category> allCategory() {
        return categoryRepository.findAll();
    }
}
