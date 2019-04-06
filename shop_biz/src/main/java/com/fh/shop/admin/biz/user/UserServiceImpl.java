/** 
 * <pre>项目名称:shop-admin-maven1 
 * 文件名称:UserServiceImpl.java 
 * 包名:com.fh.shop.backend.biz.user 
 * 创建日期:2019年1月11日上午9:17:33 
 * Copyright (c) 2019, 3222476127@qq.com  All Rights Reserved.</pre> 
 */  
package com.fh.shop.admin.biz.user;

import com.fh.core.util.MD5Util;
import com.fh.shop.admin.po.user.User;
import com.fh.shop.admin.vo.UserVO;
import com.fh.shop.backend.backend.backend.po.backend.common.DataTableResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.shop.admin.mapper.user.IUserMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/** 
 * <pre>项目名称：shop-admin-maven1    
 * 类名称：UserServiceImpl    
 * 类描述：    
 * 创建人：lihaiyan 3222476127@qq.com     
 * 创建时间：2019年1月11日 上午9:17:33    
 * 修改人：lihaiyan 3222476127@qq.com      
 * 修改时间：2019年1月11日 上午9:17:33    
 * 修改备注：       
 * @version </pre>    
 */
@Service("userService")
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserMapper userMapper;

	/**
	 * 根据用户名查看用户信息
	 */
	@Override
	public User findUserByUserName(String userName) {

		return userMapper.findUserByUserName(userName);
	}

	/**
	 * 重置上次登陆时间
	 * @param userDB
	 */
    @Override
    public void updateLastTime(User userDB) {
		userMapper.updateLastTime(userDB);
    }

	/**
	 * 登陆次数设置为0
	 * @param id
	 */
    @Override
    public void updateLoginCount(Integer id) {
		userMapper.updateLoginCount(id);
    }

	/**
	 * 登陆次数设置为一
	 * @param id
	 */
	@Override
	public void insertLoginCount(Integer id) {
		userMapper.insertLoginCount(id);
	}

	/**
	 * 注册用户
	 * @param user
	 */
    @Override
    public void addUser(User user) {
    	String t=UUID.randomUUID().toString();
		user.setSalt(t);
		user.setLoginStatus(0);
		user.setPassword(MD5Util.getStringMD5(user.getPassword()+t));
		userMapper.addUser(user);
    }

	/**
	 * 当密码输入错误时将错误的登陆次数加1 错误的登陆时间重置当前时间
	 * @param userDB
	 */
    @Override
    public void updateErrorLoginCount(User userDB) {
		userMapper.updateErrorLoginCount(new Date(),userDB.getId());
    }

	/**
	 * 登陆成功时将错误的登陆次数重置为0
	 * @param userDB
	 */
	@Override
	public void updateErrorLoginCountByZero(User userDB) {
		userMapper.updateErrorLoginCountByZero(userDB.getId());
	}


	/**
	 * 将错误的登陆时间重置当前时间 为错误的登陆次数为1
	 * @param id
	 */
    @Override
    public void insertErrorLoginTimeAndCount(Integer id) {
		userMapper.insertErrorLoginTimeAndCount(new Date(),id);
    }

	/**
	 * 将登陆状态设置为锁定锁定
	 * @param id
	 */
	@Override
	public void updateLoginStatus(Integer id) {
		userMapper.updateLoginStatus(new Date(),id);
	}


	/**
	 * 查看用户信息
	 * @param user
	 * @return
	 */
	@Override
	public DataTableResult findUserList(User user, Integer draw, int start, int length) {
		if(StringUtils.isNotEmpty(user.getDeptTreeIds())){
			List<Integer> deptIdList=new ArrayList<>();
			String[] deptIdArr = user.getDeptTreeIds().split(",");
			for (String deptId : deptIdArr) {
				deptIdList.add(Integer.valueOf(deptId));
			}
			user.setDeptTreeIdList(deptIdList);
		}

		//开始位置的下标
		user.setStartPos(start);
		//每页的条数
		user.setPageSize(length);
		//获取总条数
		Long totalCount=userMapper.findUserCount(user);

		List<User> userList=userMapper.findUserList(user);
		//包装用户VO
		List<UserVO> userVoList = wrapperUserVO(userList);
		DataTableResult data = DataTableResult.dataTableResultData(userVoList, draw, totalCount, totalCount);
		return data;
	}
	//包装用户VO
	private List<UserVO> wrapperUserVO(List<User> userList) {
		List<UserVO> userVoList=new ArrayList<>();
		for (User userInfo : userList) {
			UserVO userVo = getUserVo(userInfo);
			userVoList.add(userVo);

		}
		return userVoList;
	}
//VO转po
	private UserVO getUserVo(User userInfo) {
		UserVO userVo=new UserVO();
		userVo.setId(userInfo.getId());
		userVo.setUserName(userInfo.getUserName());
		userVo.setBirthday(userInfo.getBirthday());
		userVo.setDeptName(userInfo.getDept().getDeptName());
		userVo.setDeptId(userInfo.getDept().getId());
		userVo.setLoginStatus(userInfo.getLoginStatus());
		userVo.setPassword(userInfo.getPassword());
		userVo.setSalary(userInfo.getSalary());
		userVo.setSex(userInfo.getSex());
		userVo.setUserRealName(userInfo.getUserRealName());
		userVo.setLoginStatus(userInfo.getLoginStatus());
		return userVo;
	}

	/**
	 * 解锁
	 * @param id
	 */
    @Override
    public void updateUserLoginStatus(Integer id) {
		userMapper.updateUserLoginStatus(id);
    }
	/**
	 * 批量删除用户
	 * @param ids
	 */
	@Override
	public void deleteBatchUser(String ids) {
		String[] idArr = ids.split(",");
		List<Integer> idList = new ArrayList<>();
		for(int i=0;i<idArr.length;i++){
			idList.add(Integer.valueOf(idArr[i]));
		}
		userMapper.deleteBatchUser(idList);
	}

	/**
	 * 修改用户
	 * @param user
	 */
    @Override
    public void updateUser(User user) {
		userMapper.updateUser(user);
    }

	/**
	 *  修改回显
	 * @return
	 */
	@Override
	public UserVO findUser(Integer id) {
		User user = userMapper.findUser(id);
		UserVO userVo = getUserVo(user);
		return userVo;
	}

	/**
	 * 批量修改用户所在的部门
	 * @param ids
	 * @param deptId
	 */
    @Override
    public void BatchUpdateUserDept(List<Integer> ids, Integer deptId) {
		userMapper.BatchUpdateUserDept(ids,deptId);
    }

	/**
	 * 根据部门名称查看用户信息
	 * @param id
	 * @return
	 */
    @Override
    public List<User> findUserByDeptId(Integer id) {
		List<User> userList = userMapper.findUserByDeptId(id);
		return userList;
    }


}
