<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<core:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表</title>
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
				<td></td>
			</tr>
			<core:forEach var="student" items="${studentList}">
				<tr>
					<td><core:out value="${student.name}"></core:out></td>
					<td><core:out value="${student.number}"></core:out></td>
					<td><core:out value="${student.idcard}"></core:out></td>
					<td><core:out value="${student.teamId}"></core:out></td>
					<td><a href="./student-update-form/${student.id}" target="_blank">修改学生</a></td>
					<td><a href="./student-delete/${student.id}" target="_blank">删除学生</a></td>
				</tr>
			</core:forEach>
		</table>
		<a href="./home" target="_blank">返回主页</a>
		<a href="./student-add-form" target="_blank">添加学生</a>

	</center>

</body>
</html>