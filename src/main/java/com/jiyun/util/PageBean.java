package com.jiyun.util;

import java.util.List;

public class PageBean<T> {
	
     private Integer page;//当前页
     private Integer pageSize;//每页现实的条数
     private long totalCount;//总条数
     private long totalPage;//总页数
     private List<T> list;//展示的信息；
     
     
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
     
}
