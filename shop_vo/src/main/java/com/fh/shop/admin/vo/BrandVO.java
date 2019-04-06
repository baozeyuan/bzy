package com.fh.shop.admin.vo;

import java.io.Serializable;

public class BrandVO implements Serializable {

    private static final long serialVersionUID = 1884441824560915548L;
    //主键
    private Integer id;
    //品牌名
    private String brandName;
    //录入时间
    private String brandEntryTimeStr;
    //修改时间
    private String brandUpdateTimeStr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandEntryTimeStr() {
        return brandEntryTimeStr;
    }

    public void setBrandEntryTimeStr(String brandEntryTimeStr) {
        this.brandEntryTimeStr = brandEntryTimeStr;
    }

    public String getBrandUpdateTimeStr() {
        return brandUpdateTimeStr;
    }

    public void setBrandUpdateTimeStr(String brandUpdateTimeStr) {
        this.brandUpdateTimeStr = brandUpdateTimeStr;
    }
}
