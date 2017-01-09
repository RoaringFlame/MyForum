package com.myforum.dao.repositories;

import com.myforum.dao.domain.Reply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/1/9.
 */
@Repository
public interface ReplyRepository extends BaseRepository<Reply>{
    Page<Reply> findByThreadIdAndDeletedOrderByIdAsc(Long threadId, Boolean deleted , Pageable pageable);
}
