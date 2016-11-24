package com.myforum;

import com.myforum.dao.repositories.PersonRepository;
import com.myforum.util.filter.MyCharacterEncodingFilter;
import com.myforum.util.security.ForumUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

/**
 * Created by Administrator on 2016/11/25.
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PersonRepository personRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(new MyCharacterEncodingFilter(), ChannelProcessingFilter.class);
        http.csrf().disable();
        http.formLogin().loginPage("/login").defaultSuccessUrl("/");
        http.logout().logoutSuccessUrl("/");
        http.authorizeRequests().antMatchers("/person/*").permitAll();
//        http
//                .authorizeRequests()
//                .antMatchers("/", "/home").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new ForumUserService(personRepository))
                .passwordEncoder(new Md5PasswordEncoder());
    }
}