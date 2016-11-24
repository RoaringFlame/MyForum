package com.myforum.controller.vo;

import com.myforum.dao.domain.Person;
import com.myforum.util.VoUtil;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by Administrator on 2016/11/24.
 */
public class PersonVO {
    private String account;
    private String password;
    private String RePassword;
    private String name;
    private String sex;
    private String email;
    private String birthday;

    public static Person generateBy(PersonVO personVO, HttpServletRequest request) {
        Person person = VoUtil.copyBasic(Person.class, personVO);
        assert person != null;
        Md5PasswordEncoder md5 = new Md5PasswordEncoder();
        person.setPassword(md5.encodePassword(personVO.getPassword(), ""));
        Date date = new Date();
        person.setDateCreated(date);
        person.setDateLastActived(date);
        String ip = getRemoteHost(request);
        person.setIpCreated(ip);
        person.setIpLastActived(ip);
        return person;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return RePassword;
    }

    public void setRePassword(String rePassword) {
        RePassword = rePassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean haveEmptyElement() {
        return (account == null || "".equals(account)) || (password == null || "".equals(password)) ||
                (RePassword == null || "".equals(RePassword)) || (name == null || "".equals(name)) ||
                (sex == null || "".equals(sex)) || (email == null || "".equals(email)) ||
                (birthday == null || "".equals(birthday));
    }

    public boolean isPasswordEqualed() {
        return password.equals(RePassword);
    }

    public static String getRemoteHost(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
    }
}
