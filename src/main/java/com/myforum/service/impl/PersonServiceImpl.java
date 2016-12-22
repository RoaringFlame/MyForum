package com.myforum.service.impl;

import com.myforum.dao.domain.Person;
import com.myforum.dao.repositories.PersonRepository;
import com.myforum.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/11/24.
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public boolean isAccountHasRegistered(String account, String email) {
        if (personRepository.findByAccount(account) == null &&
                personRepository.findByEmail(email) == null) return false;
        else return true;
    }

    @Override
    public boolean isRegisterSuccess(Person person) {
        return personRepository.saveAndFlush(person) != null;
    }

    @Override
    public Person getNowPerson() {
        try {
            UserDetails userDetails = (UserDetails)
                    SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Person person = personRepository.findByAccount(userDetails.getUsername());
            return person;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Person> allPerson() {
        return personRepository.findAll();
    }
}
