<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>博旭广告</title>
</head>
<body>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
    $(function(){
    	var user_id = "${user_id}";
    	$.get("goto_set_time_etc_list.do",{user_id:user_id},function(data){
    		$("#time_etc_list").html(data);
    	});
    });
</script>
<jsp:include page="../user/user_head.jsp"></jsp:include>
<jsp:include page="../user/user_left.jsp"></jsp:include>
	  <div style="margin-left: 300px;margin-top: 70px;">
		已有定时：<br><br>
	    <div id="time_etc_list" >
	    </div><br><br>
         <input type="button" value="添加" onclick="window.location.href='goto_set_time_etc.do'">
      </div>
</body>
</html>