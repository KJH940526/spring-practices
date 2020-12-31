<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${list }  <!-- list.no 이런식으로는 접근 불가능! -->
	<h1>메일 리스트에 가입되었습니다.</h1>  <!-- 백엔드에서 리스트라는 이름으로 건내줌! -->
	<p>입력한 정보 내역입니다.</p>    <!-- 리스트라는 이름에서 뽑아서 vo라는 이름으로 넣어줌 -->
		<c:forEach items='${list }' var="vo">
		vo = ${vo }
		<table border="1" cellpadding="5" cellspacing="2">
			<tr>
				<td align=right>First name: </td>
				<td>${vo.firstName }</td>
			</tr>
			<tr>
				<td align=right width="110">Last name: </td>
				<td width="110">${vo.lastName }</td>
			</tr>
			<tr>
				<td align=right>Email address: </td>
				<td>${vo.email }</td>
			</tr>
		</table>
		<br>
		
	</c:forEach>	
	<p>			
	<!-- 경로주기!! 
	<a href='form.jsp'>추가메일 등록</a> // 
	-->
		<a href='${pageContext.request.contextPath }/add'>추가메일 등록</a>
	</p>
	<br>
</body>
</html>