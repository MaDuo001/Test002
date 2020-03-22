package com.jiyun.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.jiyun.pojo.Emp;
import com.jiyun.pojo.EmpExample;

public interface EmpMapper {
    int countByExample(EmpExample example);

    int deleteByExample(EmpExample example);

    int deleteByPrimaryKey(Integer empno);

    int insert(Emp record);

    int insertSelective(Emp record);

    List<Emp> selectByExample(EmpExample example);

    Emp selectByPrimaryKey(Integer empno);

    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);
    
    
    //查询
    List<Emp> queryJoin();
  
    List<Emp> queryJoinByEmpno(Integer empno);
    //模糊查询
	List<Emp> queryLike(Map<String, String> map);
    
	List<Emp> checkUsername(String ename);
    
}