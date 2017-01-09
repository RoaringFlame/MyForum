package com.myforum.controller.vo;

import com.myforum.dao.domain.Reply;
import com.myforum.util.IpUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Administrator on 2017/1/8.
 */
public class ReplyVO {
    private Long threadId;
    private String title;
    private String content;

    public static Reply generateBy(ReplyVO replyVO, HttpServletRequest request) {
        Reply reply = new Reply();
        reply.setTitle(replyVO.getTitle());
        reply.setContent(replyVO.getContent());
        Date date = new Date();
        reply.setDateCreated(date);
        reply.setIpCreated(IpUtil.getRemoteHost(request));
        return reply;
    }

    public Long getThreadId() {
        return threadId;
    }

    public void setThreadId(Long threadId) {
        this.threadId = threadId;
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
