package com.myforum.controller;

import com.myforum.controller.vo.PersonInfoVO;
import com.myforum.controller.vo.PersonVO;
import com.myforum.dao.domain.Person;
import com.myforum.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String registerPage(Model model) {
        PersonVO personVO = new PersonVO();
        model.addAttribute("personVO", personVO);
        model.addAttribute("messages", "你好！");
        return "register";
    }

    @RequestMapping(value = "/addPerson", method = POST)
    public String register(PersonVO personVO, HttpServletRequest request, Model model) {
        if (personVO.haveEmptyElement()) {
            model.addAttribute("personVO", personVO);
            model.addAttribute("messages", "请完善所有信息!");
            return "register";
        }
        if (personService.isAccountHasRegistered(personVO.getAccount(), personVO.getEmail())) {
            model.addAttribute("personVO", personVO);
            model.addAttribute("messages", "账户名或邮箱已被注册!");
            return "register";
        }
        if (!personVO.isPasswordEqualed()) {
            model.addAttribute("personVO", personVO);
            model.addAttribute("messages", "密码输入不一致!");
            return "register";
        }
        if (!personService.isRegisterSuccess(PersonVO.generateBy(personVO, request))) {
            model.addAttribute("personVO", personVO);
            model.addAttribute("messages", "服务器异常，请稍候再试!");
            return "register";
        } else return "/";
    }

    @RequestMapping(value = "/viewInfo", method = GET)
    public String getInfo(Model model) {
        Person person = personService.getNowPerson();
        if (person != null) {
            PersonInfoVO personInfoVO = PersonInfoVO.generateBy(person);
            model.addAttribute("person", personInfoVO);
            return "viewPerson";
        }
        return "login";
    }

    @RequestMapping(value = "/viewInfoById", method = GET)
    public String getInfoById(@RequestParam()Long personId,
                              Model model) {
        Person nowPerson = personService.getNowPerson();
        if (nowPerson != null) {
            Person person = personService.getPersonById(personId);
            PersonInfoVO personInfoVO = PersonInfoVO.generateBy(person);
            model.addAttribute("person", personInfoVO);
            return "viewPerson";
        }
        return "login";
    }
}
