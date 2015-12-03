<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	.form{
		width : 1000px;
		margin : 0 auto;
	}
</style>
</head>
<body>
<div class="form">
	
	<h2>제목 작성</h2>
	<form action="insert.html" method="post">
		<table border ="1" width="280">
			<tr><td>제목</td><td class="center"><input type="text" name="title" value=""/></td></tr>
			<tr><td>고객명</td><td class="center"><input type="text" name="cust" value=""/></td></tr>
		</table>
		<input type="submit" name="submit" value=" submit "/>
		<input type="button" name="delete" value=" delete "/>
		<input type="reset" name="reset" value=" reset "/>
	</form>
</div>
</body>
</html>