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
					<input type="text" id="context" value="">
					<input type="button" onClick="btnSearch()" value="search"/>
			</form>
		</div>
	</div>
</body>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script type="text/javascript">
	
	document.getElementById("paging").appendChild(innerCountPageNum());
	
	
	function innerCountPageNum(i){
		
		var pageCount = document.getElementById("pageCount").value;
		var pageCount = pageCount;
		var str = "";
		
		for(var i = 1; i< pageCount; i++){
		
			str += "<a href =index.html?currentPage="+i+">";
			str += i;
			str += "</a>";
			str += " ";
		}
		
		var node = document.createElement("div");
		node.innerHTML = str;
		//var textNode = document.createTextNode(str);
		
		return node;
	}
	
	function btnSearch(){
		var search = $('#context').val();
		
		if(search == "" || search == null){
			alert("Please, Enter a value");
		}else{
			$.ajax({
				type:"Get",
				url:"search.html",
				data:"content="+search,
				success: function(response){
					alert(response);
				},
				error: function(e){
					alert(e);
				}
			});
		}
	}
	
</script>
</html>