package com.myforum.controller.vo;

/**
 * Created by Administrator on 2016/12/21.
 */
public class BoardAdministratorVO {
    private Long personId;
    private Long boardId;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }
}
