<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<style type="text/css">
	.container{
		width : 1000px;
		margin : 0 auto;
	}
</style>

</head>
<body>
	<div class="container">
		<h2>People List</h2><h3>total:"${totalCount}"</h3>
		<input type="button" name="insert" value="insert" onClick="location.href='insertMove.html'"/>
		<table border = "1" width="450">
			<thead>
				<tr>
					<td width="50">Num</td>
					<td width="100">Name</td>
					<td width="200">Book</td>
					<td width="100">Date</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${custList}" var="item">
			<tr>
				<td>${item.num}</td>
				<td>${item.cust_name}</td>
				<td><a href="detail.html?num=${item.num}">${item.book_title}</a></td>
				<td>${item.borrow_date}</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<input type="hidden" id="pageCount" value="${pageCount}"/>
		<div id="paging">
			
		</div>
	
		<div id="search">
			<form>
				<div >
					Search
					<input type="text" id="context" value="">
					<button type="submit" onClick="btnSearch()">search</button>
				</div>
			</form>
		</div>
	</div>
	
<script type="text/javascript">
	
	var pageCount = document.getElementById("pageCount").value;
	
	for(var i = 0; i< pageCount; i++){
		document.getElementById("paging").appendChild(innerCountPageNum(i));
	}
	
	
	function innerCountPageNum(i){
		
		var node = document.createElement("div");
		var textNode = document.createTextNode(i);
		node.appendChild(textNode);
		
		return node;
	}
	
	function btnSearch(){
		var search = document.getElementById("context").value;
		
		if(search == "" || search == null){
			alert("Please, Enter a value");
		}else{
			
		}
	}
	
</script>
</body>
</html>