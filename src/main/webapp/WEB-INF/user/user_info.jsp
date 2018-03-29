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
</script>
<body>
<jsp:include page="user_head.jsp"></jsp:include>
<div style="margin-left: 200px;margin-top: 50px;">
   <form action="add_user_info.do" method="post" enctype="multipart/form-data">
   头像：<input type="file" name="imgd" ><br><br>
   昵称：<input type="text" name="nicheng" value="博旭"><br><br>
   真实姓名：<input type="text" name="realname" value="博旭no1"><br><br>
   身份证：<input type="text" name="idcard" value="888888888888888888"><br><br>
   手机号码：<input type="text" name="phone" value="18052494909"><br><br>
   生日：<input type="text" name="birth" value="2018.3.8"><br><br>
   店面地址：<input type="text" name="address" value="上海no1"><br><br>
   <input type="submit" value="保存">
   </form>
   </div>
</body>
</html>