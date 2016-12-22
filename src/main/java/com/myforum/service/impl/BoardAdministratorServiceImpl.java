package com.myforum.service.impl;

import com.myforum.controller.vo.BoardAdministratorVO;
import com.myforum.dao.domain.Board;
import com.myforum.dao.domain.BoardAdministrator;
import com.myforum.dao.domain.Person;
import com.myforum.dao.domain.embed.BoardAdministratorPK;
import com.myforum.dao.repositories.BoardAdministratorRepository;
import com.myforum.dao.repositories.BoardRepository;
import com.myforum.dao.repositories.PersonRepository;
import com.myforum.service.BoardAdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/12/21.
 */
@Service
public class BoardAdministratorServiceImpl implements BoardAdministratorService {

    @Autowired
    private BoardAdministratorRepository boardAdministratorRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public boolean setAdministrator(BoardAdministratorVO boardAdministratorVO) {
        Board board = boardRepository.findOne(boardAdministratorVO.getBoardId());
        Person person = personRepository.findOne(boardAdministratorVO.getPersonId());
        BoardAdministrator boardAdministrator = new BoardAdministrator();
        BoardAdministratorPK boardAdministratorPK = new BoardAdministratorPK();
        boardAdministratorPK.setAdministrator(person);
        boardAdministratorPK.setBoard(board);
        boardAdministrator.setId(boardAdministratorPK);
        return boardAdministratorRepository.saveAndFlush(boardAdministrator) != null;
    }
}
