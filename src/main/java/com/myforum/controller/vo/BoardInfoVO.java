package com.myforum.controller.vo;

import com.myforum.dao.domain.Board;
import com.myforum.dao.domain.Person;
import com.myforum.util.VoUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2016/12/21.
 */
public class BoardInfoVO {
    private Long id;
    private String name;
    private String administrators;

    public static BoardInfoVO generateBy(Board board) {
        BoardInfoVO boardInfoVO = VoUtil.copyBasic(BoardInfoVO.class, board);
        assert boardInfoVO != null;
        String administrators = "";
        Iterator i = board.getAdministrators().iterator();
        while (i.hasNext()) {
            Person person = (Person) i.next();
            administrators = administrators + person.getAccount() + " ";
        }
        boardInfoVO.setAdministrators(administrators);
        return boardInfoVO;
    }

    public static List<BoardInfoVO> generateBy(List<Board> boardList) {
        List<BoardInfoVO> list = new ArrayList<>();
        for (Board board : boardList) {
            list.add(generateBy(board));
        }
        return list;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdministrators() {
        return administrators;
    }

    public void setAdministrators(String administrators) {
        this.administrators = administrators;
    }
}
