<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>People List</h2>
		<table class="table table-bordered" width="450">
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
				<td>${item.book_title}</td>
				<td>${item.borrow_date}</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="row">
		<div class="col-sm-4">
		</div>
		<div class="col-sm-4">
			<div class="container" id="search">
				<form class="form-inline" role="form">
					<div class="form-group">
						<label for="searching">Search</label>
						<input type="text" class="form-control" id="context">
					</div>
					<button type="submit" class="btn btn-default">search</button>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>