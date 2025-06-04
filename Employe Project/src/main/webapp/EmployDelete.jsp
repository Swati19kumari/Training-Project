<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="empno" value="${param.empno}" />
	<jsp:useBean id="employDao" class="com.java.lib.EmployDaoImple" />
	<c:out value="${employDao.deleteEmployDao(empno)}" />
	<jsp:forward page="EmployShow.jsp" />

</body>
</html>