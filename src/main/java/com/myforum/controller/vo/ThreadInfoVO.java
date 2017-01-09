package com.myforum.controller.vo;

import com.myforum.dao.domain.Person;
import com.myforum.dao.domain.Thread;
import com.myforum.util.VoUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Administrator on 2017/1/6.
 */
public class ThreadInfoVO {
    private Long id;
    private Long boardId;
    private String title;
    private String content;
    private PersonInfoVO author;
    private Date dateCreated;
    private int replyCount;
    private int hit;
    private PersonInfoVO authorLastReplied;
    private Date dateLastReplied;

    public static ThreadInfoVO generateBy(Thread thread) {
        ThreadInfoVO threadInfoVO = VoUtil.copyBasic(ThreadInfoVO.class, thread);
        assert threadInfoVO != null;
        threadInfoVO.setReplyCount(thread.getReplyCount());
        threadInfoVO.setHit(thread.getHit());
        threadInfoVO.setBoardId(thread.getBoard().getId());
        threadInfoVO.setAuthor(PersonInfoVO.generateBy(thread.getAuthor()));
        Person replyPerson = thread.getAuthorLastReplied();
        if (replyPerson != null) {
            threadInfoVO.setAuthorLastReplied(PersonInfoVO.generateBy(thread.getAuthorLastReplied()));
        }
        return threadInfoVO;
    }

    public static List<ThreadInfoVO> generateBy(List<Thread> threadList) {
        List<ThreadInfoVO> list = new ArrayList<>();
        for (Thread thread : threadList) {
            list.add(generateBy(thread));
        }
        return list;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public PersonInfoVO getAuthor() {
        return author;
    }

    public void setAuthor(PersonInfoVO author) {
        this.author = author;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(int replyCount) {
        this.replyCount = replyCount;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public PersonInfoVO getAuthorLastReplied() {
        return authorLastReplied;
    }

    public void setAuthorLastReplied(PersonInfoVO authorLastReplied) {
        this.authorLastReplied = authorLastReplied;
    }

    public Date getDateLastReplied() {
        return dateLastReplied;
    }

    public void setDateLastReplied(Date dateLastReplied) {
        this.dateLastReplied = dateLastReplied;
    }
}
