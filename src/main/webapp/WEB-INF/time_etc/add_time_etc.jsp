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
			$("#start_h").append("<option value="+i+">"+i+"</option>");
			$("#end_h").append("<option value="+i+">"+i+"</option>");
			$("#bright").append("<option value="+i+">"+i+"</option>");
		}
		for(i=0;i<61;i++){
			$("#start_m").append("<option value="+i+">"+i+"</option>");
			$("#end_m").append("<option value="+i+">"+i+"</option>");
			$("#start_s").append("<option value="+i+">"+i+"</option>");
			$("#end_s").append("<option value="+i+">"+i+"</option>");
		}
	});
</script>
<body>
<jsp:include page="../user/user_head.jsp"></jsp:include>
<jsp:include page="../user/user_left.jsp"></jsp:include>
    <div style="margin-left: 300px;margin-top: 70px;">
          添加定时<br><br>
    <form action="set_time_etc.do">
        <input name="user_id" value="${user_id }" type="hidden">
        <div >开始时间：</div>
        <select id="start_h" name="start_h" style="width: 50px;">
        </select>点
        <select id="start_m" name="start_m" style="width: 50px;">
        </select>分
        <select id="start_s" name="start_s" style="width: 50px;">
        </select>秒<br><br>
        <div >结束时间：</div>
        <select id="end_h" name="end_h" style="width: 50px;">
        </select>点
        <select id="end_m" name="end_m" style="width: 50px;">
        </select>分
        <select id="end_s" name="end_s" style="width: 50px;">
        </select>秒<br><br>
         <span>亮度：</span>
         <select id="bright" name="bright" style="width: 50px;">
         </select>堪德拉每平米<br><br>
        <input type="submit" value="确定添加">
      </form>
      </div>
</body>
</html>