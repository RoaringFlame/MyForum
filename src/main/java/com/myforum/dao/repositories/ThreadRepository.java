package com.myforum.dao.repositories;

import com.myforum.dao.domain.Thread;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/1/6.
 */
@Repository
public interface ThreadRepository extends BaseRepository<Thread>{
    Page<Thread> findByBoardIdAndDeletedOrderByDateLastRepliedDesc(Long boardId, Boolean deleted , Pageable pageable);
}
