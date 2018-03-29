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
    	for(i=0;i<25;i++){
    		$("#h").append("<option value="+i+">"+i+"</option>");
    	}
    	for(i=0;i<61;i++){
    		$("#m").append("<option value="+i+">"+i+"</option>");
    		$("#s").append("<option value="+i+">"+i+"</option>");
    	}
    	var user_id = "${user_id}";
    	$.get("show_sun_down_time.do",{user_id:user_id},function(data){
    		if(data!=null){
	    		$("#h").val(data.h);
	    		$("#m").val(data.m);
	    		$("#s").val(data.s);
    		}
    	});
    });
</script>
<body>
    <jsp:include page="../user/user_head.jsp"></jsp:include>
    <jsp:include page="../user/user_left.jsp"></jsp:include>
    <div style="margin-left: 300px;margin-top: 50px;">
    <div style="margin-left: 20px;margin-top: 100px;">日落时间设置：</div>
    <div style="margin-left: 20px;margin-top: 10px;">
    <form action="set_time.do">
        <input type="hidden" name="user_id" value="${user_id }">
        <select id="h" name="h" style="width: 50px;">
        </select>点
        <select id="m" name="m" style="width: 50px;">
        </select>分
        <select id="s" name="s" style="width: 50px;">
        </select>秒
        <input type="submit" value="确定">
    </form>
    </div>
    </div>
</body>
</html>