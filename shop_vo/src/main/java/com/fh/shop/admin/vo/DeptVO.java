package com.fh.shop.admin.vo;

import java.io.Serializable;

public class DeptVO implements Serializable {
    private static final long serialVersionUID = -9093644328474486493L;

    private Integer id;
    //部门名
    private String deptName;
    //父节点
    private Integer fatherId;
    //部门描述
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
