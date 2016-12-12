package com.myforum.controller.vo;

import com.myforum.dao.domain.Board;
import com.myforum.dao.domain.Person;
import com.myforum.util.VoUtil;

import java.util.Date;
import java.util.Set;

/**
 * Created by Administrator on 2016/12/7.
 */
public class PersonInfoVO {
    private String account;
    private String name;
    private String sex;
    private String email;
    private String birthday;
    private Date dateCreated;
    private Date dateLastActived;
    private Set<Board> boardsAdministrated;

    public static PersonInfoVO generateBy(Person person) {
        PersonInfoVO personInfoVO = VoUtil.copyBasic(PersonInfoVO.class, person);
        assert personInfoVO != null;
        return personInfoVO;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateLastActived() {
        return dateLastActived;
    }

    public void setDateLastActived(Date dateLastActived) {
        this.dateLastActived = dateLastActived;
    }

    public Set<Board> getBoardsAdministrated() {
        return boardsAdministrated;
    }

    public void setBoardsAdministrated(Set<Board> boardsAdministrated) {
        this.boardsAdministrated = boardsAdministrated;
    }
}
