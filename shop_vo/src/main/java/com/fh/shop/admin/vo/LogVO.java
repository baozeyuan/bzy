package com.fh.shop.admin.vo;

import java.io.Serializable;
import java.util.Date;

public class LogVO implements Serializable {

    private static final long serialVersionUID = 7279227063801493612L;
    private Long id;
    //用户名
    private String userName;
    //做了什么事：执行了哪个类的哪个方法
    private String info;
    //1:成功，0:失败
    private Integer status;
    //创建时间
    private Date createTime;
    //花了多长时间
    private Long useTime;
    //执行内容
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUseTime() {
        return useTime;
    }

    public void setUseTime(Long useTime) {
        this.useTime = useTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
