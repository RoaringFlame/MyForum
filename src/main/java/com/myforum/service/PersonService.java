package com.myforum.service;

import com.myforum.dao.domain.Person;

import java.util.List;

public interface PersonService {
    boolean isAccountHasRegistered(String account,String email);

    boolean isRegisterSuccess(Person person);

    Person getNowPerson();

    List<Person> allPerson();
}
