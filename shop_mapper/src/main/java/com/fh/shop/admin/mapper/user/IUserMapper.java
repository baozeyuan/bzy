/** 
 * <pre>项目名称:shop-admin-maven1 
 * 文件名称:IUserMapper.java 
 * 包名:com.fh.shop.backend.mapper.user 
 * 创建日期:2019年1月11日上午9:18:34 
 * Copyright (c) 2019, 3222476127@qq.com  All Rights Reserved.</pre> 
 */  
package com.fh.shop.admin.mapper.user;

import com.fh.shop.admin.po.user.User;
import com.fh.shop.backend.po.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/** 
 * <pre>项目名称：shop-admin-maven1    
 * 类名称：IUserMapper    
 * 类描述：    
 * 创建人：lihaiyan 3222476127@qq.com     
 * 创建时间：2019年1月11日 上午9:18:34    
 * 修改人：lihaiyan 3222476127@qq.com      
 * 修改时间：2019年1月11日 上午9:18:34    
 * 修改备注：       
 * @version </pre>    
 */
public interface IUserMapper {

	/** <pre>findUserByUserName(根据用户名查看用户信息)
	 * 创建人：lihaiyan 3222476127@qq.com
	 * 创建时间：2019年1月12日 上午11:14:20
	 * 修改人：lihaiyan 3222476127@qq.com
	 * 修改时间：2019年1月12日 上午11:14:20
	 * 修改备注：
	 * @param userName
	 * @return</pre>
	 */
	User findUserByUserName(String userName);
	//重置上次登陆时间
    void updateLastTime(User userDB);
	//登陆次数设置为0
	void updateLoginCount(Integer id);
	//登陆次数设置为一
	void insertLoginCount(Integer id);
//注册用户
    void addUser(User user);
//当密码输入错误时将错误的登陆次数加1 错误的登陆时间重置当前时间
    void updateErrorLoginCount(@Param("currDate") Date date, @Param("id") Integer id);
//登陆成功时将错误的登陆次数重置为0
    void updateErrorLoginCountByZero(Integer id);
//将错误的登陆时间重置当前时间 为错误的登陆次数为1
    void insertErrorLoginTimeAndCount(@Param("currDate") Date date, @Param("id") Integer id);
//将登陆状态设置为锁定锁定
	void updateLoginStatus(@Param("currDate") Date date, @Param("id") Integer id);
//获取总条数
    Long findUserCount(User user);
//查看用户信息
	List<User> findUserList(User user);
//解锁
    void updateUserLoginStatus(Integer id);
	//批量删除用户
	void deleteBatchUser(List<Integer> idList);
//修改用户
    void updateUser(User user);
//修改回显
    User findUser(Integer id);
//批量修改用户所在的部门
    void BatchUpdateUserDept(@Param("idList") List<Integer> ids, @Param("deptId") Integer deptId);
//根据部门名称查看用户信息
    List<User> findUserByDeptId(Integer id);

}
