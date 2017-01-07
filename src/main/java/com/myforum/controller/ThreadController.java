package com.myforum.controller;

import com.myforum.controller.vo.BoardInfoVO;
import com.myforum.controller.vo.ThreadInfoVO;
import com.myforum.controller.vo.ThreadVO;
import com.myforum.dao.domain.Person;
import com.myforum.service.BoardService;
import com.myforum.service.PersonService;
import com.myforum.service.ThreadService;
import com.myforum.util.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Administrator on 2017/1/6.
 */
@Controller
@RequestMapping("/thread")
public class ThreadController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private ThreadService threadService;

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/page/list", method = GET)
    public String threadPageList(@RequestParam Long boardId,
                                 @RequestParam(required = false, defaultValue = "0") int page,
                                 @RequestParam(required = false, defaultValue = "5") int pageSize,
                                 Model model) {
        BoardInfoVO boardInfoVO = BoardInfoVO.generateBy(boardService.getBoardById(boardId));
        model.addAttribute("board", boardInfoVO);
        PageVO<ThreadInfoVO> pageVO = threadService.getThreadPage(boardId, page, pageSize);
        model.addAttribute("page", pageVO);
        return "listThread";
    }

    @RequestMapping(value = "/addPage", method = GET)
    public String threadAddPage(@RequestParam Long boardId,
                                Model model) {
        BoardInfoVO boardInfoVO = BoardInfoVO.generateBy(boardService.getBoardById(boardId));
        model.addAttribute("board", boardInfoVO);
        ThreadVO threadVO = new ThreadVO();
        model.addAttribute("threadVO", threadVO);
        return "addThread";
    }

    @RequestMapping(value = "/add", method = POST)
    public String addThread(ThreadVO threadVO,
                            HttpServletRequest request,
                            RedirectAttributes attr) {
        Person nowPerson = personService.getNowPerson();
        if (nowPerson != null) {
            threadService.addThread(threadVO,nowPerson, request);
            attr.addAttribute("boardId", threadVO.getBoardId());
            return "redirect:/thread/page/list";
        }
        return "login";
    }
}
