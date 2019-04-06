/** 
 * <pre>项目名称:shop-admin-maven1 
 * 文件名称:User.java 
 * 包名:com.fh.shop.backend.po.user 
 * 创建日期:2019年1月11日上午9:14:11 
 * Copyright (c) 2019, 3222476127@qq.com  All Rights Reserved.</pre> 
 */  
package com.fh.shop.admin.po.user;

import com.fh.shop.admin.po.Page;
import com.fh.shop.admin.po.dapt.Dept;
import com.fh.shop.backend.po.Page;
import com.fh.shop.backend.po.dapt.Dept;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <pre>项目名称：shop-admin-maven1    
 * 类名称：User    
 * 类描述：    
 * 创建人：lihaiyan 3222476127@qq.com     
 * 创建时间：2019年1月11日 上午9:14:11    
 * 修改人：lihaiyan 3222476127@qq.com      
 * 修改时间：2019年1月11日 上午9:14:11    
 * 修改备注：       
 * @version </pre>    
 */
public class User extends Page implements Serializable {

	private static final long serialVersionUID = -4585230943919478898L;
	private Integer id;
	//用户名
	private String userName;
	//密码
	private String password;
	//密码加盐
	private String salt;
	//验证码
	private String imageCode;
	//上次登陆时间
	private Date lastLoginTime;
	//登陆次数
	private Integer loginCount;
	//错误登陆次数
	private Integer errorLoginCount;
	//错误登陆时间
	private Date errorLoginTime;
	//登陆状态
	private Integer loginStatus;
	//真是姓名
	private String userRealName;
	//生日
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	private String birthdayStr;
	//性别
	private Integer sex;
	//薪资
	private Double salary;

	//部门
	private Dept dept=new Dept();

	//选中项目时用户表条件查询
	private String deptTreeIds;
	private List<Integer> deptTreeIdList;

	//条件查询字段
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date minBirthday;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date maxBirthday;
	private Double minSalary;
	private Double maxSalary;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getImageCode() {
		return imageCode;
	}

	public void setImageCode(String imageCode) {
		this.imageCode = imageCode;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Integer getErrorLoginCount() {
		return errorLoginCount;
	}

	public void setErrorLoginCount(Integer errorLoginCount) {
		this.errorLoginCount = errorLoginCount;
	}

	public Date getErrorLoginTime() {
		return errorLoginTime;
	}

	public void setErrorLoginTime(Date errorLoginTime) {
		this.errorLoginTime = errorLoginTime;
	}

	public Integer getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(Integer loginStatus) {
		this.loginStatus = loginStatus;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getMinBirthday() {
		return minBirthday;
	}

	public void setMinBirthday(Date minBirthday) {
		this.minBirthday = minBirthday;
	}

	public Date getMaxBirthday() {
		return maxBirthday;
	}

	public void setMaxBirthday(Date maxBirthday) {
		this.maxBirthday = maxBirthday;
	}

	public Double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Double minSalary) {
		this.minSalary = minSalary;
	}

	public Double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Double maxSalary) {
		this.maxSalary = maxSalary;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String getBirthdayStr() {
		return birthdayStr;
	}

	public void setBirthdayStr(String birthdayStr) {
		this.birthdayStr = birthdayStr;
	}

	public String getDeptTreeIds() {
		return deptTreeIds;
	}

	public void setDeptTreeIds(String deptTreeIds) {
		this.deptTreeIds = deptTreeIds;
	}

	public List<Integer> getDeptTreeIdList() {
		return deptTreeIdList;
	}

	public void setDeptTreeIdList(List<Integer> deptTreeIdList) {
		this.deptTreeIdList = deptTreeIdList;
	}
}
