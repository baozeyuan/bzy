package com.fh.shop.admin.po;

import java.io.Serializable;

public class Page implements Serializable{
	private static final long serialVersionUID = -1366315130996067436L;
	//总条数
	private long  totalCount;
	//总页数
	private long pageCount;
	//每页的条数
	private long pageSize = 3;
	//当前页
	private long pageIndex = 1;
	//起始位置
	private long startPos;
	//终止位置
	private long endPos;	
	
	//价格 日期排序字段
	private String sortFiled;
	private String sort;//sort将…排顺序
	
	//计算分页信息
	public void calculatePage(){
		//获取总页数
		if(totalCount % pageSize ==0){
			pageCount = totalCount / pageSize;
		}else{
			pageCount = totalCount / pageSize + 1;
		}
		// 1 0 5 >0 <=5
		// 2 5 10 >5 <=10
		// 3 10 15 >10 <=15
		startPos = ( pageIndex - 1 ) * pageSize;
		endPos = pageIndex * pageSize;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public long getPageCount() {
		return pageCount;
	}

	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public long getStartPos() {
		return startPos;
	}

	public void setStartPos(long startPos) {
		this.startPos = startPos;
	}

	public long getEndPos() {
		return endPos;
	}

	public void setEndPos(long endPos) {
		this.endPos = endPos;
	}

	public long getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(long pageIndex) {
		this.pageIndex = pageIndex;
	}

	public String getSortFiled() {
		return sortFiled;
	}

	public void setSortFiled(String sortFiled) {
		this.sortFiled = sortFiled;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	
	
	
}
