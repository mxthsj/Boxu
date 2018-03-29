<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>博旭广告</title>
</head>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/layer/layer.js"></script>
<script type="text/javascript">
   function login(){
	   var key = 0;
	   var type = $("#type").val();
	   var username = $("#username").val();
	   re_username=/^[a-z0-9_-]{3,16}$/;
	   if(username==""){
		   key = 1;
		   alert("账户不能为空！");
		   return false;
	   }else if(!re_username.test(username)){
		   key = 1;
		   alert("格式要求：26个英文字母小写，数字0-9，3到16位！");
		   return false;
	   }
	   var password = $("#password").val();
	   re_password=/^[a-z0-9_-]{6,18}$/;
	   if(password==""){
		   key = 1;
		   alert("密码不能为空！");
		   return false;
	   }else if(!re_password.test(password)){
		   key = 1;
		   alert("格式要求：26个英文字母小写，数字0-9，6到18位！");
		   return false;
	   }
	   if(key==0 && type=="user"){
		   $.ajax({
			   type:"post",
			   url:"login.do",
			   data:{
				   "username":username,
				   "password":password
			   },
			   success:function(result){
				   if(result.success){
					   window.location.href="goto_user.do";
				   }else{
					   layer.msg(result.message, {time:1000, icon:5, shift:6});
				   }
			   }
		   });
	   }else if(key==0 && type=="manager"){
		   $.ajax({
			   type:"post",
			   url:"manager_login.do",
			   data:{
				   "username":username,
				   "password":password
			   },
			   success:function(result){
				   if(result.success){
					   window.location.href="goto_manager.do";
				   }else{
					   layer.msg(result.message, {time:1000, icon:5, shift:6});
				   }
			   }
		   });
	   }
   }
</script>
<body>
    <div style="margin-left: 500px;margin-top: 200px;">
    <form action="login.do">
        
        帐号：<input id="username" name="username" value="testele"><br><br>
        密码：<input id="password" name="password" value="testele"><br><br>
        <select id="type" name="type" style="height: 25px;">
        <option value="manager">管理者</option>
        <option value="user" selected="selected">客户</option>
        </select><br><br>
        <a href="goto_regist.do">注册</a>|<a href="find_password.do">忘记密码</a>&nbsp;&nbsp;
        <input type="button" onclick="login()" value="登录">
    </form>
    </div>
    
</body>
</html>