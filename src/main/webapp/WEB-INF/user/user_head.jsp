<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>博旭广告</title>
</head>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
    $(function(){
    	$.get("get_img.do",function(result){
    		if(result.data!=null){
	    		var a = result.data.img;
	    		$("#img").attr("src","img/"+a);
    		}else{
    			$("#img").attr("src","img/default.jpg");
    		}
    	});
    });
</script>
<body>
    
    <div style="margin-left: 20px;">
	<div style="border: 1px black solid;width: 55px;">
	<img id="img" src="" style="width: 50px;height: 50px;">
	</div>
	欢迎<span style="color:red;">${login_name }</span>
	<a href="loginout.do">退出登录</a>
	<a href="user_info.do">个人信息</a>
	<a href="goto_user.do">首页</a>
	
	</div>
	<hr>
</body>
</html>