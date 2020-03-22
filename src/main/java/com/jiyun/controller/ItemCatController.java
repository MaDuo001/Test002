package com.jiyun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiyun.pojo.TbItemCat;
import com.jiyun.service.ItemCatService;

@RestController
public class ItemCatController {

	
	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/js/findByparentId")
	public List<TbItemCat> findByparentId(@RequestParam(defaultValue="0") Long parentId){
	    List<TbItemCat> eList=itemCatService.findByParentId(parentId);
		return eList;

     }
}