package com.fh.shop.admin.biz.area;

import com.fh.shop.admin.mapper.area.IAreaMapper;
import com.fh.shop.admin.po.area.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("areaService")
public class AreaServiceImpl implements IAreaService{
    @Autowired
    private IAreaMapper areaMapper;

    /**
     * 查看地区信息
     * @return
     */
    @Override
    public List<Area> findAreaList() {
        List<Area> areaList = areaMapper.findAreaList();
        return areaList;
    }
}
