package com.fh.shop.admin.po.member;

import com.fh.shop.admin.po.Page;
import com.fh.shop.backend.po.Page;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Member extends Page implements Serializable {
    private static final long serialVersionUID = -7240301554440702016L;

    private Integer id;

    private String userName;//用户名

    private String password;//密码

    private String phone;//电话

    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;//生日

    private String birthdayStr;//生日

    private Date regTime;//注册时间

    private Date lastLoginTime;//上次登陆时间

    private String areaName;//家庭地址

    private String areaIds;

    public String getAreaIds() {
        return areaIds;
    }

    public void setAreaIds(String areaIds) {
        this.areaIds = areaIds;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date minBirthday;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxBirthday;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getBirthdayStr() {
        return birthdayStr;
    }

    public void setBirthdayStr(String birthdayStr) {
        this.birthdayStr = birthdayStr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getMinBirthday() {
        return minBirthday;
    }

    public void setMinBirthday(Date minBirthday) {
        this.minBirthday = minBirthday;
    }

    public Date getMaxBirthday() {
        return maxBirthday;
    }

    public void setMaxBirthday(Date maxBirthday) {
        this.maxBirthday = maxBirthday;
    }
}
