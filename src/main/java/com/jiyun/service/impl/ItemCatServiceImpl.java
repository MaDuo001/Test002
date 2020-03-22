 package com.jiyun.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jiyun.mapper.TbItemCatMapper;
import com.jiyun.pojo.TbItemCat;
import com.jiyun.pojo.TbItemCatExample;
import com.jiyun.pojo.TbItemCatExample.Criteria;
import com.jiyun.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {
   
	
	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	
	@Override
	public List<TbItemCat> findByParentId(Long parentId) {
		return tbItemCatMapper.queryByParentId(parentId);
	}

}
