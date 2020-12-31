<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%pageContext.setAttribute("newline", "\n");%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/add" method="post">
		<input type="hidden" name='a' value="add"/>
		<table border=1 width=500>
			<tr>
				<td>이름</td><td><input type="text" name="name"></td>
				<td>비밀번호</td><td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan=4><textarea name="message" cols=60 rows=5></textarea></td>
			</tr>
			<tr>
				<td colspan=4 align=right><input type="submit" VALUE="등록"></td>
			</tr>
		</table>
	</form>

	<br>
	list : ${list } <br/>   <!-- list에는 toString으로 정의한 값이 넘어온다! 근데 toString에는  "message=" + message 이런식으로 되어있음!
							따라서 여기 출력되는건 "message" + 값이 나오기떄문에 데이터에 접근하기 위해서는 값(필드명)을 통해서 접근해야한다. -->
	<br/>
	<c:forEach items='${list }' var="vo">
	${vo }<br/>
	<table width=510 border=1>
		<tr >
			<td>[${index}]</td>
			<td>${vo.name }</td>
			<td>${vo.regDate }</td>
			<td ><a  href="${pageContext.request.contextPath }/delete?no=${vo.no}">삭제</a></td>
		</tr>
		<tr>
			<td colspan=4>${fn:replace(vo.message, newline, "<br>") }</td> <!-- 클라이언트에서 바꾸기! -->
		</tr>
	</table>
	<br/>
	</c:forEach>	
</body>
</html>