<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<core:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hahaha</title>
</head>
<body>
<center>
<h1>welcome:${currentUser.identity}</h1>

<p><core:out value="${currentUser.name}"></core:out></p>
<p><core:out value="${currentUser.email}"></core:out></p>

<a href="../student/questionList" target="_blank">Question List</a>
</center>
</body>
</html>