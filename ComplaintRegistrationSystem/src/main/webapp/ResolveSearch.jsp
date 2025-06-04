<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Resolve by Complaint ID</title>

    <!-- Styling only -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f4f8;
            padding: 30px;
        }
        .form-container {
            max-width: 500px;
            margin: auto;
            background-color: #ffffff;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #333333;
            margin-bottom: 20px;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
            font-size: 14px;
        }
        input[type="submit"] {
            width: 100%;
            background-color: #28a745;
            color: white;
            border: none;
            padding: 12px;
            font-size: 16px;
            margin-top: 20px;
            border-radius: 6px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>Search Resolution by Complaint ID</h2>
    <form method="get" action="ResolveSearch.jsp">
        <input type="text" name="complaintId" placeholder="Enter Complaint ID" value="${resolve.complaintId}" required />
        <br/>
        <input type="submit" value="Search" />
    </form>
</div>

<jsp:useBean id="resolveDao" class="com.java.crm.Dao.ResolveDaoImpl" />
<jsp:useBean id="resolve" class="com.java.crm.model.Resolve" />
<jsp:setProperty property="*" name="resolve" />

<c:if test="${not empty param.complaintId}">
    <%
        String complaintId = request.getParameter("complaintId");
        com.java.crm.model.Resolve result = resolveDao.getResolveByComplaintId(complaintId);
        request.setAttribute("resolve", result);
    %>
    <jsp:forward page="ResolveShowById.jsp" />
</c:if>

</body>
</html>
