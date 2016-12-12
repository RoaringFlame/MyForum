package com.myforum.controller;

import com.myforum.controller.vo.CategoryVO;
import com.myforum.dao.domain.Category;
import com.myforum.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Administrator on 2016/12/6.
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = GET)
    public String categoryAddPage(Model model) {
        CategoryVO categoryVO = new CategoryVO();
        model.addAttribute("categoryVO", categoryVO);
        return "addCategory";
    }

    @RequestMapping(value = "/add", method = POST)
    public String addCategory(CategoryVO categoryVO) {
        categoryService.addCategory(CategoryVO.generateBy(categoryVO));
        return "redirect:/category/list";
    }

    @RequestMapping(value = "/list", method = GET)
    public String categoryList(Model model) {
        List<Category> categoryList = categoryService.allCategory();
        model.addAttribute("categoryList", categoryList);
        return "listCategory";
    }

}
