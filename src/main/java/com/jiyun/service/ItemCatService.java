package com.jiyun.service;

import java.util.List;

import com.jiyun.pojo.TbItemCat;

public interface ItemCatService {
	
	//查询所有
	public List<TbItemCat> findByParentId(Long parentId); 
	
	

}
