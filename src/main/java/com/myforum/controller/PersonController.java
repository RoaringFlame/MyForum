package com.myforum.controller;

import com.myforum.controller.vo.PersonVO;
import com.myforum.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


/**
 * Created by Administrator on 2016/11/24.
 */
@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/registerPage", method = GET)
    public String registerPage(Model model){
        PersonVO personVO = new PersonVO();
        model.addAttribute("personVO",personVO);
        model.addAttribute("messages","你好！");
        return "register";
    }

    @RequestMapping(value = "/addPerson", method = POST)
    public String register(PersonVO personVO, HttpServletRequest request, Model model){
        if(personVO.haveEmptyElement()){
            model.addAttribute("personVO",personVO);
            model.addAttribute("messages","请完善所有信息!");
            return "register";
        }
        if(personService.isAccountHasRegistered(personVO.getAccount(),personVO.getEmail())){
            model.addAttribute("personVO",personVO);
            model.addAttribute("messages","账户名或邮箱已被注册!");
            return "register";
        }
        if(!personVO.isPasswordEqualed()){
            model.addAttribute("personVO",personVO);
            model.addAttribute("messages","密码输入不一致!");
            return "register";
        }
        if(!personService.isRegisterSuccess(personVO.generateBy(personVO,request))){
            model.addAttribute("personVO",personVO);
            model.addAttribute("messages","服务器异常，请稍候再试!");
            return "register";
        }else return "/";
    }
}