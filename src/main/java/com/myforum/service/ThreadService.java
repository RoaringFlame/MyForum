package com.myforum.service;

import com.myforum.controller.vo.ThreadInfoVO;
import com.myforum.controller.vo.ThreadVO;
import com.myforum.dao.domain.Person;
import com.myforum.dao.domain.Thread;
import com.myforum.util.PageVO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/1/6.
 */
public interface ThreadService {
    boolean addThread(ThreadVO threadVO, Person author, HttpServletRequest request);

    PageVO<ThreadInfoVO> getThreadPage(Long boardId, int page, int pageSize);

    Thread getThreadById(Long threadId);
}
