/** 
 * <pre>项目名称:shop-admin-maven1 
 * 文件名称:IUserService.java 
 * 包名:com.fh.shop.backend.biz.user 
 * 创建日期:2019年1月11日上午9:17:14 
 * Copyright (c) 2019, 3222476127@qq.com  All Rights Reserved.</pre> 
 */  
package com.fh.shop.admin.biz.user;

import com.fh.shop.admin.po.user.User;
import com.fh.shop.admin.vo.UserVO;
import com.fh.shop.backend.backend.backend.po.backend.common.DataTableResult;

import java.util.List;

/** 
 * <pre>项目名称：shop-admin-maven1    
 * 类名称：IUserService    
 * 类描述：    
 * 创建人：lihaiyan 3222476127@qq.com     
 * 创建时间：2019年1月11日 上午9:17:14    
 * 修改人：lihaiyan 3222476127@qq.com      
 * 修改时间：2019年1月11日 上午9:17:14    
 * 修改备注：       
 * @version </pre>    
 */
public interface IUserService {

	/** <pre>findUserByUserName(根据用户名查看用户信息)
	 * 创建人：lihaiyan 3222476127@qq.com
	 * 创建时间：2019年1月12日 上午11:12:57
	 * 修改人：lihaiyan 3222476127@qq.com
	 * 修改时间：2019年1月12日 上午11:12:57
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
    void updateErrorLoginCount(User userDB);
//登陆成功时将错误的登陆次数重置为0
	void updateErrorLoginCountByZero(User userDB);
//将错误的登陆时间重置当前时间 为错误的登陆次数为1
    void insertErrorLoginTimeAndCount(Integer id);
//将登陆状态设置为锁定锁定
	void updateLoginStatus(Integer id);
//查看用户信息
 DataTableResult findUserList(User user, Integer draw, int start, int length);
//解锁
    void updateUserLoginStatus(Integer id);
	//批量删除用户
	void deleteBatchUser(String ids);
//修改用户
    void updateUser(User user);
// 修改回显
    UserVO findUser(Integer id);
//批量修改用户所在的部门
	void BatchUpdateUserDept(List<Integer> ids, Integer deptId);
//根据部门id查看用户信息
	List<User> findUserByDeptId(Integer id);
}
