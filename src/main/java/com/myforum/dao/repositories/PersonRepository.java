package com.myforum.dao.repositories;

import com.myforum.dao.domain.Person;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/11/23.
 */
@Repository
public interface PersonRepository extends BaseRepository<Person> {
    Person findByAccount(String account);

    Person findByEmail(String email);
}
