package com.myforum.controller.vo;

import com.myforum.dao.domain.Thread;
import com.myforum.util.IpUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Administrator on 2017/1/5.
 */
public class ThreadVO {
    private Long boardId;
    private String title;
    private String content;

    public static Thread generateBy(ThreadVO threadVO, HttpServletRequest request) {
        Thread thread = new Thread();
        thread.setTitle(threadVO.getTitle());
        thread.setContent(threadVO.getContent());
        Date date = new Date();
        thread.setDateCreated(date);
        thread.setDateLastReplied(date);
        thread.setIpCreated(IpUtil.getRemoteHost(request));
        thread.setHit(0);
        thread.setReadonly(false);
        thread.setTopped(false);
        thread.setReplyCount(0);
        return thread;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
