package com.myforum.controller;

import com.myforum.controller.vo.BoardAdministratorVO;
import com.myforum.controller.vo.BoardInfoVO;
import com.myforum.controller.vo.BoardVO;
import com.myforum.dao.domain.Category;
import com.myforum.dao.domain.Person;
import com.myforum.service.BoardAdministratorService;
import com.myforum.service.BoardService;
import com.myforum.service.CategoryService;
import com.myforum.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Administrator on 2016/12/20.
 */
@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PersonService personService;

    @Autowired
    private BoardAdministratorService boardAdministratorService;

    @RequestMapping(method = GET)
    public String BoardAddPage(Model model) {
        BoardVO boardVO = new BoardVO();
        model.addAttribute("boardVO", boardVO);
        List<Category> categoryList = categoryService.allCategory();
        model.addAttribute("categoryList", categoryList);
        return "addBoard";
    }

    @RequestMapping(value = "/add", method = POST)
    public String addBoard(BoardVO boardVO) {
        boardService.addBoard(boardVO);
        return "redirect:/category/list";
    }

    @RequestMapping(value = "/setAdminPage", method = GET)
    public String setAdminPage(Model model) {
        BoardAdministratorVO boardAdministratorVO = new BoardAdministratorVO();
        model.addAttribute("boardAdministratorVO", boardAdministratorVO);
        List<BoardInfoVO> boardList = BoardInfoVO.generateBy(boardService.allBoard());
        model.addAttribute("boardList", boardList);
        List<Person> personList = personService.allPerson();
        model.addAttribute("personList", personList);
        return "setAdmin";
    }

    @RequestMapping(value = "/setAdmin", method = POST)
    public String setAdmin(BoardAdministratorVO boardAdministratorVO) {
        boardAdministratorService.setAdministrator(boardAdministratorVO);
        return "redirect:/category/list";
    }
}
