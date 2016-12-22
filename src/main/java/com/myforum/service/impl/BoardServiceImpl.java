package com.myforum.service.impl;

import com.myforum.controller.vo.BoardVO;
import com.myforum.dao.domain.Board;
import com.myforum.dao.repositories.BoardRepository;
import com.myforum.dao.repositories.CategoryRepository;
import com.myforum.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/12/20.
 */
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean addBoard(BoardVO boardVO) {
        Board board = BoardVO.generateBy(boardVO);
        board.setCategory(categoryRepository.findOne(boardVO.getCategoryId()));
        return boardRepository.saveAndFlush(board) != null;
    }

    @Override
    public List<Board> allBoard() {
        return boardRepository.findAll();
    }
}
