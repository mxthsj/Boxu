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
function regist(){
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
	   var email = $("#email").val();
	   re_email=/^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
	   if(email==""){
		   key = 1;
		   alert("邮箱不能为空！");
		   return false;
	   }else if(!re_email.test(email)){
		   key = 1;
		   alert("请填写正确的邮箱格式！");
		   return false;
	   }
	   if(key==0 && type=="user"){
		   $.ajax({
			   type:"post",
			   url:"regist.do",
			   data:{
				   "username":username,
				   "password":password,
				   "email":email
			   },
			   success:function(result){
				   if(result.success){
					   window.location.href="goto_login.do";
				   }else{
					   layer.msg(result.message, {time:1000, icon:5, shift:6});
				   }
			   }
		   });
	   }else if(key==0 && type=="manager"){
		   $.ajax({
			   type:"post",
			   url:"manager_regist.do",
			   data:{
				   "username":username,
				   "password":password,
				   "email":email
			   },
			   success:function(result){
				   if(result.success){
					   window.location.href="goto_login.do";
				   }else{
					   layer.msg(result.message, {time:1000, icon:5, shift:6});
				   }
			   }
		   });
	   }
}
</script>
<body>
     <div style="margin-left: 500px;margin-top: 100px;">
	     <form action="regist.do">
			  注册帐号：<input id="username" name="username" value=""><br><br>
			  注册密码：<input id="password" name="password" value=""><br><br>
			  注册邮箱<input id="email" name="email" value=""><br><br>
			<select id="type" name="type" style="height: 25px;">
			<option value="manager">管理者</option>
			<option value="user">客户</option>
			</select><br><br>
			<a href="goto_login.do">我有帐号</a>&nbsp;&nbsp;
			<input type="button" onclick="regist()" value="注册"> 
	     </form>
     </div>
     <div style="margin-left: 500px;margin-top: 20px;">温馨提示：</div>
    <div style="margin-left: 500px;margin-top: 10px;margin-right: 500px;">
     邮箱为必填项，方便您在忘记密码的时候找回密码，建议您注册成功后立即填写个人信息，如身份证手机号码等信息，方便我们对您的帐号进行维护，帐号注册成功后，将跳转至登录页面
    </div>
</body>
</html>