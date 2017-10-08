<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hahaha</title>
</head>
<body>
<center>
<h1>welcome:</h1>

<p><jstl:out value="${currentUser.identity}"></jstl:out></p>
<p><jstl:out value="${currentUser.name}"></jstl:out></p>
<p><jstl:out value="${currentUser.email}"></jstl:out></p>


</center>
</body>
</html>