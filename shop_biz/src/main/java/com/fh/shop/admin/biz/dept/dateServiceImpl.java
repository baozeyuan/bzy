package com.fh.shop.admin.biz.dept;

import com.fh.core.util.CacheManager;
import com.fh.shop.admin.mapper.dapt.IDeptMapper;
import com.fh.shop.admin.po.dapt.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("deptService")
public class dateServiceImpl implements IDeptService{

   @Autowired
    private IDeptMapper deptMapper;

    /**
     * 查看项目信息
     * @return
     */
    @Override
    public List<Dept> findDeptList() {
        //获取单例模式【双重判定锁】创建的对象
        CacheManager instance = CacheManager.getInstance();
        //先获取缓存中的信息
        Object object = instance.getObj("deptList");
        //如果对象不为空则证明缓存中有值 就不用跟数据库交互去查询数据库了
        if(object!=null){
            return (List<Dept>) object;
        }
        //否则的话就查询数据库
        List<Dept> deptList = deptMapper.findDeptList();
        //再将查询出来的值放入到缓存中
        //注意：上下两个key值一定要对应 否则就获取不到缓存中的值
        instance.putObj("deptList",deptList);
        return deptList;
    }

    /**
     * 添加项目
     * @param dept
     */
    @Override
    public void addDept(Dept dept) {
        deptMapper.addDept(dept);
        //刷新缓存
        CacheManager.getInstance().remove("deptList");
    }

    /**
     * 删除项目
     * @param ids
     */
    @Override
    public void deleteDept(List<Integer> ids) {
            deptMapper.deleteDept(ids);
        //刷新缓存
        CacheManager.getInstance().remove("deptList");
    }

    /**
     * 修改部门
     * @param dept
     */
    @Override
    public void updateDept(Dept dept) {
            deptMapper.updateDept(dept);
        //刷新缓存
        CacheManager.getInstance().remove("deptList");
    }

    /**
     * 根据选中的节点的子节点id查看子节点信息
     * @param childNode
     * @return
     */
    @Override
    public List<Dept> findChildByChiledId(List<Integer> childNode) {
        List<Dept> DeptList = deptMapper.findChildByChiledId(childNode);
        return DeptList;
    }

    /**
     * 根据父节点查看所有的子部门
     * @param deptId
     * @return
     */
    @Override
    public List<Dept> findDeptByFatherId(Integer deptId) {
        List<Dept> deptList = deptMapper.findDeptByFatherId(deptId);
        if (!deptList.isEmpty()){
            for (int i = 0; i < deptList.size(); i++) {
                Dept dept = deptList.get(i);
                this.findDeptByFatherId(dept.getId());
            }
        }
        return deptList;
    }


}
