package com.fh.shop.admin.mapper.dapt;

import com.fh.shop.admin.po.dapt.Dept;
import com.fh.shop.backend.po.dapt.Dept;

import java.util.List;

public interface IDeptMapper {

//查看项目信息
    List<Dept> findDeptList();
//添加项目
    void addDept(Dept dept);

//删除项目
    void deleteDept(List<Integer> ids);
//修改部门
    void updateDept(Dept dept);
    //根据选中的节点的子节点id查看子节点信息
    List<Dept> findChildByChiledId(List<Integer> childNode);
    //根据父节点查看
    List<Dept> findDeptByFatherId(Integer id);

}
