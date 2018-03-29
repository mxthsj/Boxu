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
    	 var user_id = "${user_id}";
    	 $.get("show_overcurrent_protection.do",{user_id:user_id},function(data){
    		 if(data!=null){
    			 $("#overcurrent_s").val(data.overcurrent_s);
    			 $("#overcurrent_e").val(data.overcurrent_e);
    		 }
    	 });
     });
     function verification(){
    	 var overcurrent_s=$("#overcurrent_s").val();
    	 if(overcurrent_s==""){
    		 return false;
    	 }
    	 if(overcurrent_s>15||overcurrent_s<5){
    		 alert("最小阈值请保持在5-15！");
    		 return false;
    	 }
    	 var overcurrent_e=$("#overcurrent_e").val();
    	 if(overcurrent_e==""){
    		 return false;
    	 }
    	 if(overcurrent_e>35||overcurrent_e<25){
    		 alert("最大阈值请保持在25-35！");
    		 return false;
    	 }
    	 $("#submit").submit();
     }
</script>
<body>
    <jsp:include page="../user/user_head.jsp"></jsp:include>
    <jsp:include page="../user/user_left.jsp"></jsp:include>
    <div style="margin-left: 300px;margin-top: 70px;">
    overcurrent_protection
    <h4>默认超过额定电流的10%-30%，切断负载电源</h4><br>
    修改：<br><br>
    <form id="submit" action="edit_overcurrent_protection.do">
    <input type="hidden" name="user_id" value="${user_id }">
        超过额定电流的
        <input id="overcurrent_s" type="text" name="overcurrent_s" style="width: 50px;">%-
        <input id="overcurrent_e" type="text" name="overcurrent_e" style="width: 50px;">%
        切断负载电源<br><br>
        <input  type="button" onclick="verification()" value="确认修改">
    </form>
    </div>
</body>
</html>