package com.jiyun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiyun.pojo.Emp;
import com.jiyun.service.EmpService;
import com.jiyun.util.PageBean;
import com.jiyun.util.Result;

@Controller
public class EmpController {
  
	@Autowired
	private EmpService empService;
	//所有
	@RequestMapping("/findAll")
    @ResponseBody
    public List<Emp> findAll(){
		return empService.findAll();
		
	}
	//保存
	@RequestMapping("/saveEmp")
	
	public Result saveEmp( Emp emp){
		 try {
			 empService.saveEmp(emp);
			 return new Result(true,"保存成功！！");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false,"保存失败！");
		}
		 
		
	}
	//修改
	@RequestMapping(value="/updateEmp")
	public Result updateEmp(Emp emp){
		   try {
			empService.updateEmp(emp);
			return new Result(true,"修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false,"修改失败");
		}
	}
	  //查询单个
		@RequestMapping(value="/findOne")
		public Emp findOne(int empno){
			   return empService.findOne(empno);
		}
		//删除
		@RequestMapping(value="/deleteEmp")
		public Result deleteEmp(int empeno){
			   try {
				empService.deleteEmp(empeno);
				return new Result(true,"删除成功");
			} catch (Exception e) {
				e.printStackTrace();
				return new Result(false,"删除失败");
			}
		}
		
		//查询
		@RequestMapping("/queryJoin")
		public String queryJoin(Model model){
            List<Emp> list = empService.queryJoin();  
		    model.addAttribute("list", list);
		    return "empJoin";
   }
		@RequestMapping("/queryJoinByEmpno")
		@ResponseBody
		public List<Emp> queryJoinByEmpno(Integer empno){
				return empService.queryJoinByEmpno(empno);
      }
		//模糊查询
		@RequestMapping("/queryLike")
		public String queryLike(String ename,String dname,Model model,@RequestParam(defaultValue="1")int page){
		     PageBean<Emp> pageBean = empService.queryLike(ename, dname,page,3);
		     model.addAttribute("pageBean",pageBean);
		     return "empJoin";
		}  
		
		@RequestMapping("/register")
		public String show(){
			return "register";
		}
		
		@RequestMapping("/checkUsername")
		@ResponseBody
		public Result checkUsername(String username){
		    boolean flag = empService.checkUsername(username);
		    System.out.println(flag);
		      if (flag) {//查询到的内容
				   return new Result(false,"不可用");
			}else{
				 return new Result(true,"可用");
			} 
		         
		}
		
}