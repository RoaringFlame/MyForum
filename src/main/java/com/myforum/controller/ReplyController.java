package com.myforum.controller;

import com.myforum.controller.vo.BoardInfoVO;
import com.myforum.controller.vo.ReplyInfoVO;
import com.myforum.controller.vo.ReplyVO;
import com.myforum.controller.vo.ThreadInfoVO;
import com.myforum.dao.domain.Person;
import com.myforum.service.BoardService;
import com.myforum.service.PersonService;
import com.myforum.service.ReplyService;
import com.myforum.service.ThreadService;
import com.myforum.util.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Administrator on 2017/1/8.
 */
@Controller
@RequestMapping("/reply")
public class ReplyController {
    @Autowired
    private BoardService boardService;

    @Autowired
    private ThreadService threadService;

    @Autowired
    private PersonService personService;

    @Autowired
    private ReplyService replyService;

    @RequestMapping(value = "/page/list", method = GET)
    public String replyPageList(@RequestParam(required = false) Long threadId,
                                @RequestParam(required = false) Long id,
                                @RequestParam(required = false, defaultValue = "0") int page,
                                @RequestParam(required = false, defaultValue = "5") int pageSize,
                                HttpSession httpSession,    //取值判断是否为翻页或者添加，否则hit计数加1
                                Model model) {
        if (id != null) threadId = id;
        ThreadInfoVO threadInfoVO = ThreadInfoVO.generateBy(threadService.getThreadById(threadId));
        model.addAttribute("thread", threadInfoVO);
        BoardInfoVO boardInfoVO = BoardInfoVO.generateBy(boardService.getBoardById(threadInfoVO.getBoardId()));
        model.addAttribute("board", boardInfoVO);
        Object hasViewedThreadId = httpSession.getAttribute("threadId");
        boolean isCountHit = true;
        if (hasViewedThreadId != null && threadId == (long) hasViewedThreadId) {
            isCountHit = false;
        } else {
            httpSession.setAttribute("threadId", threadId);
            isCountHit = true;
        }
        PageVO<ReplyInfoVO> pageVO = replyService.getRelyPage(threadId, page, pageSize, isCountHit);
        model.addAttribute("page", pageVO);
        return "listReply";
    }

    @RequestMapping(value = "/addPage", method = GET)
    public String threadAddPage(@RequestParam Long threadId,
                                Model model) {
        ThreadInfoVO threadInfoVO = ThreadInfoVO.generateBy(threadService.getThreadById(threadId));
        model.addAttribute("thread", threadInfoVO);
        BoardInfoVO boardInfoVO = BoardInfoVO.generateBy(boardService.getBoardById(threadInfoVO.getBoardId()));
        model.addAttribute("board", boardInfoVO);
        ReplyVO replyVO = new ReplyVO();
        model.addAttribute("replyVO", replyVO);
        return "addReply";
    }

    @RequestMapping(value = "/add", method = POST)
    public String addThread(ReplyVO replyVO,
                            HttpServletRequest request,
                            RedirectAttributes attr) {
        Person nowPerson = personService.getNowPerson();
        if (nowPerson != null) {
            replyService.addReply(replyVO, nowPerson, request);
            attr.addAttribute("threadId", replyVO.getThreadId());
            return "redirect:/reply/page/list";
        }
        return "login";
    }
}
