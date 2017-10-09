<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<core:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Students lists</title>
</head>
<body>
   	<center>
		<table border="1">
			<tr>
				<td>姓名</td>
				<td>学号</td>
				<td>身份证号</td>
				<td>班级</td>
				<td></td>
			</tr>
			<core:forEach var="student" items="${studentList}">
				<tr>
					<td><core:out value="${student.name}"></core:out></td>
					<td><core:out value="${student.number}"></core:out></td>
					<td><core:out value="${student.idcard}"></core:out></td>
					<td><core:out value="${question.teamId}"></core:out></td>
				</tr>
			</core:forEach>
		</table>
					<a href="./home">返回主页</a>

	</center>

</body>
</html>