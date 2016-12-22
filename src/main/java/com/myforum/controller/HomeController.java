package com.myforum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Administrator on 2016/12/12.
 */

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = GET)
    public String goHome() {
        return "redirect:/category/list";
    }

    @RequestMapping(value = "/index", method = GET)
    public String home() {
        return "redirect:/category/list";
    }

}
