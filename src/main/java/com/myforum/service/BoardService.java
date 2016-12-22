package com.myforum.service;

import com.myforum.controller.vo.BoardVO;
import com.myforum.dao.domain.Board;

import java.util.List;

/**
 * Created by Administrator on 2016/12/20.
 */
public interface BoardService {
    boolean addBoard(BoardVO boardVO);

    List<Board> allBoard();
}
