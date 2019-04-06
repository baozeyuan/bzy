package com.fh.shop.admin.po.log;

import com.fh.shop.admin.po.Page;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Log extends Page implements Serializable {

    private static final long serialVersionUID = -3653714726511836496L;
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

    //条件查询字段
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date minCreateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date maxCreateTime;
    private Long minUseTime;
    private Long maxUseTime;


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

    public Date getMinCreateTime() {
        return minCreateTime;
    }

    public void setMinCreateTime(Date minCreateTime) {
        this.minCreateTime = minCreateTime;
    }

    public Date getMaxCreateTime() {
        return maxCreateTime;
    }

    public void setMaxCreateTime(Date maxCreateTime) {
        this.maxCreateTime = maxCreateTime;
    }

    public Long getMinUseTime() {
        return minUseTime;
    }

    public void setMinUseTime(Long minUseTime) {
        this.minUseTime = minUseTime;
    }

    public Long getMaxUseTime() {
        return maxUseTime;
    }

    public void setMaxUseTime(Long maxUseTime) {
        this.maxUseTime = maxUseTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
