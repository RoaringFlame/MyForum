package com.myforum.service.impl;

import com.myforum.controller.vo.ReplyInfoVO;
import com.myforum.controller.vo.ReplyVO;
import com.myforum.dao.domain.Board;
import com.myforum.dao.domain.Person;
import com.myforum.dao.domain.Reply;
import com.myforum.dao.domain.Thread;
import com.myforum.dao.repositories.BoardRepository;
import com.myforum.dao.repositories.ReplyRepository;
import com.myforum.dao.repositories.ThreadRepository;
import com.myforum.service.ReplyService;
import com.myforum.util.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/1/9.
 */
@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ThreadRepository threadRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Transactional
    @Override
    public boolean addReply(ReplyVO replyVO, Person person, HttpServletRequest request) {
        Thread thread = threadRepository.findOne(replyVO.getThreadId());
        Reply reply = ReplyVO.generateBy(replyVO, request);
        int floor = thread.getReplyCount() + 1;
        reply.setFloor(floor);
        reply.setThread(thread);
        reply.setAuthor(person);
        reply = replyRepository.saveAndFlush(reply);
        thread.setReplyCount(floor);
        thread.setDateLastReplied(reply.getDateCreated());
        thread.setAuthorLastReplied(person);
        thread = threadRepository.saveAndFlush(thread);
        Board board = thread.getBoard();
        board.setLastReply(reply);
        board.setReplyCount(board.getReplyCount() + 1);
        return boardRepository.saveAndFlush(board) != null;
    }

    @Override
    public PageVO<ReplyInfoVO> getRelyPage(Long threadId, int page, int pageSize, boolean isCountHit) {
        if (isCountHit) {
            Thread thread = threadRepository.findOne(threadId);
            thread.setHit(thread.getHit() + 1);
            threadRepository.saveAndFlush(thread);
        }
        Page<Reply> replyPage = replyRepository.findByThreadIdAndDeletedOrderByIdAsc(threadId, Boolean.FALSE, new PageRequest(page, pageSize));
        PageVO<ReplyInfoVO> pageVO = new PageVO<>();
        pageVO.toPage(replyPage);
        pageVO.setItems(ReplyInfoVO.generateBy(replyPage.getContent()));
        return pageVO;
    }
}
