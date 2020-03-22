package com.jiyun.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jiyun.mapper.EmpMapper;
import com.jiyun.pojo.Emp;
import com.jiyun.service.EmpService;
import com.jiyun.util.PageBean;

@Service
public class EmpServiceImpl implements EmpService{
 
	@Autowired
	private EmpMapper empMapper;
	//所有
	@Override
	public List<Emp> findAll() {
		// TODO Auto-generated method stub
		return empMapper.selectByExample(null);
	}
    //保存
	@Override
	public void saveEmp(Emp emp) {
		// TODO Auto-generated method stub
		empMapper.insert(emp);
	}
	//修改
	@Override
	public void updateEmp(Emp emp) {
		// TODO Auto-generated method stub
		empMapper.updateByPrimaryKey(emp);
		
	}
	//查询单个
	@Override
	public Emp findOne(int empno) {
		// TODO Auto-generated method stub
		return empMapper.selectByPrimaryKey(empno);
	}
	//删除
	@Override
	public void deleteEmp(int empeno) {
		// TODO Auto-generated method stub
		empMapper.deleteByPrimaryKey(empeno);
	}
	//查询
	@Override
	public List<Emp> queryJoin() {
		// TODO Auto-generated method stub
		return empMapper.queryJoin();
	}
	@Override
	public List<Emp> queryJoinByEmpno(Integer empno) {
		// TODO Auto-generated method stub
		return empMapper.queryJoinByEmpno(empno);
	}
	@Override
	public PageBean<Emp> queryLike(String ename, String dname,int page,int pageSize) {
		PageHelper.startPage(page, pageSize);	
		Map<String, String> map=new HashMap<String, String>();
		map.put("ename", ename);
		map.put("dname", dname);
		//执行查询返回pageInfo分页对象
		Page<Emp> pages=(Page<Emp>) empMapper.queryLike(map); 
		//封装pageBean中需要的数据
		PageBean<Emp> pageBean=new PageBean<Emp>();
		pageBean.setPage(page);//但前页
		pageBean.setPageSize(pageSize);//每页显示的条数
		long totalCount=pages.getTotal();
		pageBean.setTotalCount(totalCount);//总条数
		//计算出一个总页数
		long totalPage=(totalCount+pageSize-1)/pageSize;
		pageBean.setTotalPage(totalPage);//总页数
		pageBean.setList(pages.getResult());//返回的记录
		return pageBean;
	}
	@Override
	public boolean checkUsername(String ename) {
	    List<Emp> list = empMapper.checkUsername(ename);
	    System.out.println(list);
		  if (list==null && list.size()>0) {
			    return true;
		  }else{
			  	return false;
		}
	}

}
