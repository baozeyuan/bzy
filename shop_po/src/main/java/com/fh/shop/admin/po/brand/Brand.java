/** 
 * <pre>项目名称:shop-admin-v2 
 * 文件名称:Brand.java 
 * 包名:com.fh.shop.backend.po.brand 
 * 创建日期:2018年12月27日下午10:24:59 
 * Copyright (c) 2018, 3222476127@qq.com  All Rights Reserved.</pre> 
 */  
package com.fh.shop.admin.po.brand;

import java.io.Serializable;
import java.util.Date;

import com.fh.shop.admin.po.Page;
import org.springframework.format.annotation.DateTimeFormat;

import com.fh.shop.backend.po.Page;

/** 
 * <pre>项目名称：shop-admin-v2    
 * 类名称：Brand    
 * 类描述：    
 * 创建人：lihaiyan 3222476127@qq.com     
 * 创建时间：2018年12月27日 下午10:24:59    
 * 修改人：lihaiyan 3222476127@qq.com      
 * 修改时间：2018年12月27日 下午10:24:59    
 * 修改备注：       
 * @version </pre>    
 */
public class Brand extends Page implements Serializable{
	private static final long serialVersionUID = 1L;
	//主键
	private Integer id;
	//品牌名
	private String brandName;
	//录入时间
	private Date brandEntryTime;
	//修改时间
	private Date brandUpdateTime;
	private String brandEntryTimeStr;
	private String brandUpdateTimeStr;
	//条件查询字段
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date minBrandEntryTime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date maxBrandEntryTime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date minBrandUpdateTime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date maxBrandUpdateTime;

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Date getBrandEntryTime() {
		return brandEntryTime;
	}
	public void setBrandEntryTime(Date brandEntryTime) {
		this.brandEntryTime = brandEntryTime;
	}
	public Date getBrandUpdateTime() {
		return brandUpdateTime;
	}
	public void setBrandUpdateTime(Date brandUpdateTime) {
		this.brandUpdateTime = brandUpdateTime;
	}
	public Date getMinBrandEntryTime() {
		return minBrandEntryTime;
	}
	public void setMinBrandEntryTime(Date minBrandEntryTime) {
		this.minBrandEntryTime = minBrandEntryTime;
	}
	public Date getMaxBrandEntryTime() {
		return maxBrandEntryTime;
	}
	public void setMaxBrandEntryTime(Date maxBrandEntryTime) {
		this.maxBrandEntryTime = maxBrandEntryTime;
	}
	public Date getMinBrandUpdateTime() {
		return minBrandUpdateTime;
	}
	public void setMinBrandUpdateTime(Date minBrandUpdateTime) {
		this.minBrandUpdateTime = minBrandUpdateTime;
	}
	public Date getMaxBrandUpdateTime() {
		return maxBrandUpdateTime;
	}
	public void setMaxBrandUpdateTime(Date maxBrandUpdateTime) {
		this.maxBrandUpdateTime = maxBrandUpdateTime;
	}
	
	public String getBrandEntryTimeStr() {
		return brandEntryTimeStr;
	}
	public void setBrandEntryTimeStr(String brandEntryTimeStr) {
		this.brandEntryTimeStr = brandEntryTimeStr;
	}
	public String getBrandUpdateTimeStr() {
		return brandUpdateTimeStr;
	}
	public void setBrandUpdateTimeStr(String brandUpdateTimeStr) {
		this.brandUpdateTimeStr = brandUpdateTimeStr;
	}

	@Override
	public String toString() {
		return "Brand{" +
				"id=" + id +
				", brandName='" + brandName + '\'' +
				", brandEntryTime=" + brandEntryTime +
				", brandUpdateTime=" + brandUpdateTime +
				", brandEntryTimeStr='" + brandEntryTimeStr + '\'' +
				", brandUpdateTimeStr='" + brandUpdateTimeStr + '\'' +
				", minBrandEntryTime=" + minBrandEntryTime +
				", maxBrandEntryTime=" + maxBrandEntryTime +
				", minBrandUpdateTime=" + minBrandUpdateTime +
				", maxBrandUpdateTime=" + maxBrandUpdateTime +
				'}';
	}
}
