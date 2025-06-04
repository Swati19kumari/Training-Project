<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Complaint</title>

    <!-- Only Styling Added -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f4f8;
            padding: 20px;
        }
        .search-card {
            background-color: #ffffff;
            max-width: 400px;
            margin: auto;
            padding: 25px;
            border-radius: 12px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .search-card h2 {
            color: #333;
            margin-bottom: 20px;
        }
        .search-card input[type="text"] {
            width: 100%;
            padding: 10px;
            font-size: 14px;
            border-radius: 6px;
            border: 1px solid #ccc;
            margin-bottom: 15px;
            box-sizing: border-box;
        }
        .search-card input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007BFF;
            border: none;
            color: white;
            font-size: 15px;
            border-radius: 6px;
            cursor: pointer;
        }
        .search-card input[type="submit"]:hover {
            background-color: #0069d9;
        }
    </style>
</head>
<body>

    <form method="get" action="ComplaintSearch.jsp">
        <div class="search-card">
            <h2>🔍 Search Complaint by ID</h2>
            <input type="text" name="complaintId" value="${complaint.complaintId}" placeholder="Enter Complaint ID" />
            <br>
            <input type="submit" value="Search">
        </div>
    </form>

    <jsp:useBean id="complaintDao" class="com.java.crm.Dao.ComplaintDaoImpl" />
    <jsp:useBean id="complaint" class="com.java.crm.model.Complaint" />
    <jsp:setProperty property="*" name="complaint" />

    <c:if test="${not empty param.complaintId}">
        <%
            String complaintId = request.getParameter("complaintId");
            com.java.crm.model.Complaint result = complaintDao.searchComplaintById(complaintId);
            request.setAttribute("complaint", result);
        %>
        <jsp:forward page="ComplaintShowById.jsp" />
    </c:if>

</body>
</html>
