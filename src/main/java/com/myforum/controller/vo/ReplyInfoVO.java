package com.myforum.controller.vo;

import com.myforum.dao.domain.Reply;
import com.myforum.util.VoUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/1/9.
 */
public class ReplyInfoVO {
    private String title;
    private String content;
    private PersonInfoVO author;
    private int floor;
    private Date dateCreated;

    public static ReplyInfoVO generateBy(Reply reply) {
        ReplyInfoVO replyInfoVO = VoUtil.copyBasic(ReplyInfoVO.class, reply);
        assert replyInfoVO != null;
        replyInfoVO.setFloor(reply.getFloor());
        replyInfoVO.setAuthor(PersonInfoVO.generateBy(reply.getAuthor()));
        return replyInfoVO;
    }

    public static List<ReplyInfoVO> generateBy(List<Reply> replyList) {
        List<ReplyInfoVO> list = new ArrayList<>();
        for (Reply reply : replyList) {
            list.add(generateBy(reply));
        }
        return list;
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

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
