/** 
 * <pre>项目名称:shop-admin-v2 
 * 文件名称:Product.java 
 * 包名:com.fh.shop.backend.po.product 
 * 创建日期:2018年12月23日下午8:02:19 
 * Copyright (c) 2018, 3222476127@qq.com  All Rights Reserved.</pre> 
 */  
package com.fh.shop.admin.po.product;

import java.io.Serializable;
import java.util.Date;

import com.fh.shop.admin.po.DataTablePage;
import com.fh.shop.backend.po.DataTablePage;
import org.springframework.format.annotation.DateTimeFormat;

import com.fh.shop.backend.po.Page;
import com.fh.shop.backend.po.brand.Brand;

/** 
 * <pre>项目名称：shop-admin-v2    
 * 类名称：Product    
 * 类描述：    
 * 创建人：lihaiyan 3222476127@qq.com     
 * 创建时间：2018年12月23日 下午8:02:19    
 * 修改人：lihaiyan 3222476127@qq.com      
 * 修改时间：2018年12月23日 下午8:02:19    
 * 修改备注：       
 * @version </pre>    
 */
public class Product extends DataTablePage implements Serializable{

	private static final long serialVersionUID = 5306087749856060545L;

	private Integer id;//主键
	
	private String productName;//商品名称
	
	private Float productPrice;//商品价格
	
	private Date entryTime;//录入时间
	
	private Date updateTime;//修改时间

	private String productImagePath;//商品图片

	private String ids;//修改删除子图片时传到后台的图片id字符串

	private String entryTimeStr;
	private String updateTimeStr;

	private String productImagePathChildren;

	private String productImagePathHuiXian;
	
	private Brand brand=new Brand();
	//条件查询
	private Float minPrice;	
	private Float maxPrice;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date minEntryTime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date maxEntryTime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date minUpdateTime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date maxUpdateTime;

	public String getProductImagePathHuiXian() {
		return productImagePathHuiXian;
	}

	public void setProductImagePathHuiXian(String productImagePathHuiXian) {
		this.productImagePathHuiXian = productImagePathHuiXian;
	}

	public String getProductImagePathChildren() {
		return productImagePathChildren;
	}

	public void setProductImagePathChildren(String productImagePathChildren) {
		this.productImagePathChildren = productImagePathChildren;
	}

	public Date getMinEntryTime() {
		return minEntryTime;
	}

	public void setMinEntryTime(Date minEntryTime) {
		this.minEntryTime = minEntryTime;
	}

	public Date getMaxEntryTime() {
		return maxEntryTime;
	}

	public void setMaxEntryTime(Date maxEntryTime) {
		this.maxEntryTime = maxEntryTime;
	}

	public Date getMinUpdateTime() {
		return minUpdateTime;
	}

	public void setMinUpdateTime(Date minUpdateTime) {
		this.minUpdateTime = minUpdateTime;
	}

	public Date getMaxUpdateTime() {
		return maxUpdateTime;
	}

	public void setMaxUpdateTime(Date maxUpdateTime) {
		this.maxUpdateTime = maxUpdateTime;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}

	public Float getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Float minPrice) {
		this.minPrice = minPrice;
	}

	public Float getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Float maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getEntryTimeStr() {
		return entryTimeStr;
	}

	public void setEntryTimeStr(String entryTimeStr) {
		this.entryTimeStr = entryTimeStr;
	}

	public String getUpdateTimeStr() {
		return updateTimeStr;
	}

	public void setUpdateTimeStr(String updateTimeStr) {
		this.updateTimeStr = updateTimeStr;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getProductImagePath() {
		return productImagePath;
	}

	public void setProductImagePath(String productImagePath) {
		this.productImagePath = productImagePath;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	@Override
	public String toString() {
		return "Product{" +
				"id=" + id +
				", productName='" + productName + '\'' +
				", productPrice=" + productPrice +
				", entryTime=" + entryTime +
				", updateTime=" + updateTime +
				", productImagePath='" + productImagePath + '\'' +
				", ids='" + ids + '\'' +
				", entryTimeStr='" + entryTimeStr + '\'' +
				", updateTimeStr='" + updateTimeStr + '\'' +
				", brand=" + brand +
				", minPrice=" + minPrice +
				", maxPrice=" + maxPrice +
				", minEntryTime=" + minEntryTime +
				", maxEntryTime=" + maxEntryTime +
				", minUpdateTime=" + minUpdateTime +
				", maxUpdateTime=" + maxUpdateTime +
				'}';
	}
}
