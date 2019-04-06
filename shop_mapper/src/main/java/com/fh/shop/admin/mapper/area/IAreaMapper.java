package com.fh.shop.admin.mapper.area;

import com.fh.shop.admin.po.area.Area;
import com.fh.shop.backend.po.area.Area;

import java.util.List;

public interface IAreaMapper {

//查看地区信息
    List<Area> findAreaList();
}
