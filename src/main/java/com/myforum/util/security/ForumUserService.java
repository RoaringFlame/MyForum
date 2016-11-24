package com.myforum.util.security;

import com.myforum.dao.domain.Person;
import com.myforum.dao.repositories.PersonRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */
public class ForumUserService implements UserDetailsService {
    private final PersonRepository personRepository;

    public ForumUserService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Person fuser = personRepository.findByAccount(username);
        if (fuser != null) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            User userInfo = new User(fuser.getAccount(), fuser.getPassword(),
                    !fuser.isDeleted(), true, true, true, authorities);
            return userInfo;
        }

        throw new UsernameNotFoundException(
                "User '" + username + "' not found.");
    }
}
