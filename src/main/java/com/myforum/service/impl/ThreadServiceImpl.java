package com.myforum.service.impl;

import com.myforum.controller.vo.ThreadInfoVO;
import com.myforum.controller.vo.ThreadVO;
import com.myforum.dao.domain.Board;
import com.myforum.dao.domain.Person;
import com.myforum.dao.domain.Thread;
import com.myforum.dao.repositories.BoardRepository;
import com.myforum.dao.repositories.ThreadRepository;
import com.myforum.service.ThreadService;
import com.myforum.util.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/1/6.
 */
@Service
public class ThreadServiceImpl implements ThreadService {

    @Autowired
    private ThreadRepository threadRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    @Override
    public boolean addThread(ThreadVO threadVO, Person author, HttpServletRequest request) {
        Thread thread = ThreadVO.generateBy(threadVO, request);
        thread.setBoard(boardRepository.findOne(threadVO.getBoardId()));
        thread.setAuthor(author);
        thread = threadRepository.saveAndFlush(thread);
        Board board = thread.getBoard();
        board.setLastThread(thread);
        board.setThreadCount(board.getThreadCount() + 1);
        return boardRepository.saveAndFlush(board) != null;
    }

    @Override
    public PageVO<ThreadInfoVO> getThreadPage(Long boardId, int page, int pageSize) {
        Page<Thread> threadPage = threadRepository.
                findByBoardIdAndDeletedOrderByDateLastRepliedDesc(boardId, Boolean.FALSE, new PageRequest(page, pageSize));
        PageVO<ThreadInfoVO> pageVO = new PageVO<>();
        pageVO.toPage(threadPage);
        pageVO.setItems(ThreadInfoVO.generateBy(threadPage.getContent()));
        return pageVO;
    }

    @Override
    public Thread getThreadById(Long threadId) {
        return threadRepository.findOne(threadId);
    }
}
