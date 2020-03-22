<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-2.2.1.min.js"></script>
<script type="text/javascript">
            $(function(){
                $(".emps").click(function(){
                	var empno=$(this).attr("aa")
                	//  alert(empno);
                	//向后台发送ajax请求，获取到数据，展示到前台。。。
                	   $.getJSON("queryJoinByEmpno?empno="+empno,function(data){ 
                		   var str="";
                		   $.each(data,function(index,info){
                			str="<table border='2'><tr><td>"+info.ename+"</td><td>"+info.job+"</td><td>"+info.age+"</td><td>"+info.dept.dname+"</td><td>"+info.dept.loc+"</td></tr></table>"
                		   })
                	   		$("#divs").html(str);
                	   })
                })
            	
            })
          

</script>
</head>
<body>
     <p>多条件查询</p>
     <form action="queryLike" method="post">
   请输入员工姓名：<input type="text" name="ename" value=""> 请输入部门名称：<input type="text" name="dname" value=""> 
       <input type="submit" value="查询"> <br>&nbsp; &nbsp;
     </form>  
    <table border="1">
         <tr>
            <td>员工号</td>
            <td>姓名</td>
            <td>年龄</td>
            <td>岗位</td>
            <td>部门</td>
            <td>部门所在地</td>
         </tr>
        <c:forEach items="${pageBean.list }" var="e">
         <tr class="emps" aa="${e.empno }">
            <td>${e.empno }</td>
            <td>${e.ename }</td>
            <td>${e.age }</td>
            <td>${e.job }</td>
            <td>${e.dept.dname }</td>
            <td>${e.dept.loc }</td>
         </tr>
        </c:forEach>
    </table>
       <div>
        <c:if test="${pageBean.page!=1 }">
           <a href="queryLike?page=1">首页</a>
          <a href="queryLike?page=${pageBean.page-1 }">上一页</a>
        </c:if>
           <c:forEach var="i" begin="1" end="${pageBean.totalPage }">
              <a href="queryLike?page=${i}">${i}</a>
           
           </c:forEach>
    
        <c:if test="${pageBean.page != pageBean.totalPage }">
            <a href="queryLike?page=${pageBean.page+1 }">下一页</a>
           <a href="queryLike?page=${pageBean.totalPage }">尾页</a>
        </c:if>
       ${pageBean.totalCount}条/${pageBean.totalPage }页
    </div>
    <div id="divs">
    </div>
</body>
</html>