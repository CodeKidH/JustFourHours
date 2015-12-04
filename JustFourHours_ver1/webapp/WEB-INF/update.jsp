<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	.center{
		width:1000px;
		margin: 0 auto;
	}
</style>
</head>
<body>
	<div class="center">
		<h2>업데이트</h2>
		<form action="update.html" method="post">
			<table border ="1">
				<c:set value="${oneList }" var="list"/>
				<tr><td>제목</td><td><input type="text" name="title" value="${list.book_title}"/></td></tr>
				<tr><td>고객명</td><td><input type="text" name="cust" value="${list.cust_name}"/></td></tr>
			</table>
			<input type="hidden" id="num" value="${list.num }"/>
			<input type="submit" name="submit" value=" submit "/>
			<input type="button" name="delete" value=" delete " onClick='btnClick()' />
		</form>
	</div>
	
	
<script type="text/javascript">
	
	function btnClick(){
		
		var num = document.getElementById("num").value;
		
		location.href("delete.html?num="+num);
	}
	
	
</script>
</body>
</html>