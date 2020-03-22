package com.jiyun.service;

import java.util.List;

import com.jiyun.pojo.Emp;
import com.jiyun.util.PageBean;

public interface EmpService {
    //所有
	public List<Emp> findAll();
	//保存
	public void saveEmp(Emp emp);
	//修改
	public void updateEmp(Emp emp);
	//查询单个
	public Emp findOne(int empno); 
	//删除
	public void deleteEmp(int empeno);
	
	
	//查询
	public List<Emp> queryJoin();
	
	public List<Emp> queryJoinByEmpno(Integer empno);
	//模糊查询
	public PageBean<Emp> queryLike(String ename,String dname,int page,int pageSize);
	
	public boolean checkUsername(String ename);
}
