package com.myforum.util.listener;

import com.myforum.dao.domain.Person;
import com.myforum.dao.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class AuthenticationSuccessEventListener
        implements ApplicationListener<AuthenticationSuccessEvent> {

    @Autowired
    private PersonRepository personRepository;

    public void onApplicationEvent(AuthenticationSuccessEvent e) {
        UserDetails userDetails = (UserDetails)
                e.getAuthentication().getPrincipal();
        WebAuthenticationDetails details = (WebAuthenticationDetails)
                e.getAuthentication().getDetails();
        Person person = personRepository.findByAccount(userDetails.getUsername());
        person.setIpLastActived(details.getRemoteAddress());
        Date date = new Date();
        person.setDateLastActived(date);
        personRepository.saveAndFlush(person);
    }
}