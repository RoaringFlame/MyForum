package com.myforum.service;

import com.myforum.dao.domain.Person;

public interface PersonService {
    boolean isAccountHasRegistered(String account,String email);

    boolean isRegisterSuccess(Person person);

    Person getNowPerson();
}
