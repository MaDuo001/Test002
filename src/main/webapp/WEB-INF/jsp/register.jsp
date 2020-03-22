<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-2.2.1.min.js"></script>

<script type="text/javascript">
        $(function(){
        	$("#btn").click(function(){
                $.ajax({
                	 url:"checkUsername",
                	 type:"get",
                	 datatype:"Json",
                	 cache:false,
                	 data:"username="+$("#username").val(),
                	 success:function(data){
                		 if(data.success){
     						$("#ps").html("恭喜该用户名可用")
                	 }else{
                		    $("#ps").html("该用户已被占用");
                	 	}
                	 }
                	 
                })
        	})
        })
</script>

</head>
<body>
    <table>
         <tr>
           <td>用户名</td>
           <td><input type="text" value="" id="username"></td>
             <td>
                <input type="button" id="btn" value="验证">
                <span id="ps"></span>
             </td>
         </tr>
    
    </table>
   
</body>
</html>