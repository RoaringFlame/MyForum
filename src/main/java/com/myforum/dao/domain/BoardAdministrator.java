package com.myforum.dao.domain;

import com.myforum.dao.domain.embed.BoardAdministratorPK;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016/12/21.
 */
@Entity
@Table(name = "t_board_administrator")
@org.hibernate.annotations.Entity
public class BoardAdministrator {

    @EmbeddedId
    private BoardAdministratorPK id;

    public BoardAdministratorPK getId() {
        return id;
    }

    public void setId(BoardAdministratorPK id) {
        this.id = id;
    }
}
