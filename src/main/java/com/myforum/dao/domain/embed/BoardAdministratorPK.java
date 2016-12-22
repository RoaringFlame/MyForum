package com.myforum.dao.domain.embed;

import com.myforum.dao.domain.Board;
import com.myforum.dao.domain.Person;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Administrator on 2016/12/21.
 */
public class BoardAdministratorPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name="person_id")
    private Person administrator;

    public BoardAdministratorPK(){}

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Person getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Person administrator) {
        this.administrator = administrator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoardAdministratorPK that = (BoardAdministratorPK) o;

        if (board != null ? !board.equals(that.board) : that.board != null) return false;
        return administrator != null ? administrator.equals(that.administrator) : that.administrator == null;

    }

    @Override
    public int hashCode() {
        int result = board != null ? board.hashCode() : 0;
        result = 31 * result + (administrator != null ? administrator.hashCode() : 0);
        return result;
    }
}
