package com.fh.shop.admin.po.area;

import java.io.Serializable;

public class Area implements Serializable {

    private static final long serialVersionUID = 4893008910702923552L;

    private Integer id;

    private Integer pid;

    private String cityName;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }


}
