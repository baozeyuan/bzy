package com.fh.shop.admin.biz.area;

import com.fh.shop.admin.po.area.Area;

import java.util.List;

public interface IAreaService {
    //查看地区信息
    List<Area> findAreaList();
}
