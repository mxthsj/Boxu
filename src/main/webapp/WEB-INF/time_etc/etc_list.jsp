<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>博旭广告</title>
</head>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
   function delete_time_etc(id){
	   $.get("delete_time_etc.do",{id:id},function(data){
		   window.location.href="goto_set_time_etc_list_page.do";
	   });
   }
</script>
<body>
    <table border="1" bordercolor="#a0c6e5" style="border-collapse:collapse;">
         <tr height="40px;">
            <td align="center" width="50px;" >序号</td>
            <td align="center" width="200px;">开始时间</td>
            <td align="center" width="200px;">结束时间</td>
            <td align="center" width="50px;">亮度</td>
            <td align="center" width="200px;" colspan="2">操作</td>
         </tr>
         <c:forEach items="${time_etc_list }" var="time_etc" varStatus="k" >
            <tr height="40px;">
               <td align="center">${k.count }</td>
               <td align="center">${time_etc.start_t }</td>
               <td align="center">${time_etc.end_t }</td>
               <td align="center">${time_etc.etc }</td>
               <td align="center">
                 <input type="button" value="删除" onclick="delete_time_etc(${time_etc.id })">
               </td>
               <td align="center">
                 <input type="button" value="修改" onclick="window.location.href='goto_edit_time_etc_page.do?id=${time_etc.id }'">
               </td>
            </tr>
         </c:forEach>
      </table>
</body>
</html>