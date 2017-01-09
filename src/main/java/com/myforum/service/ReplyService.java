package com.myforum.service;

import com.myforum.controller.vo.ReplyInfoVO;
import com.myforum.controller.vo.ReplyVO;
import com.myforum.dao.domain.Person;
import com.myforum.util.PageVO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/1/9.
 */
public interface ReplyService {
    boolean addReply(ReplyVO replyVO, Person person, HttpServletRequest request);

    PageVO<ReplyInfoVO> getRelyPage(Long threadId, int page, int pageSize, boolean isCountHit);
}
