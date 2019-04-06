package com.fh.shop.admin.biz;

public class BaseService {

    //获取dataTable传过来的属性名
    protected String getColumnData(String orderColumn) {
        return "columns["+orderColumn+"][data]";
    }

}
