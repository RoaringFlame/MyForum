package com.myforum.controller.vo;

import com.myforum.dao.domain.Board;
import com.myforum.util.VoUtil;

import java.util.Date;

/**
 * Created by Administrator on 2016/12/12.
 */
public class BoardVO {
    private Long categoryId;
    private String name;
    private String description;

    public static Board generateBy(BoardVO boardVO) {
        Board board = VoUtil.copyBasic(Board.class, boardVO);
        assert board != null;
        Date date = new Date();
        board.setDateCreated(date);
        board.setThreadCount(0);
        board.setReplyCount(0);
        return board;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
