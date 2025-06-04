<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Date, java.time.LocalDate, java.time.temporal.ChronoUnit" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resolved Complaints</title>

    <!-- Styling only -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #eef1f5;
            padding: 30px;
        }
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0,0,0,0.05);
        }
        th, td {
            padding: 12px 15px;
            border: 1px solid #ccc;
            text-align: center;
        }
        th {
            background-color: #007bff;
            color: white;
        }

        /* TAT-based row colors */
        .red {
            background-color: #f8d7da;
            color: #721c24;
        }
        .yellow {
            background-color: #fff3cd;
            color: #856404;
        }
        .green {
            background-color: #d4edda;
            color: #155724;
        }
        .gray {
            background-color: #f0f0f0;
            color: #333;
        }
    </style>
</head>
<body>

<h2>Resolved Complaints</h2>

<jsp:useBean id="resolveDao" class="com.java.crm.Dao.ResolveDaoImpl" />
<c:set var="resolveList" value="${resolveDao.getAllResolves()}" />

<table>
    <tr>
        <th>Complaint ID</th>
        <th>Complaint Date</th>
        <th>Resolve Date</th>
        <th>Resolved By</th>
        <th>Comments</th>
        <th>TAT (Days)</th>
    </tr>

    <c:forEach var="res" items="${resolveList}">
        <%
            com.java.crm.model.Resolve r = (com.java.crm.model.Resolve) pageContext.getAttribute("res");
            Date complaintDate = r.getComplaintDate();
            Date resolveDate = r.getResolveDate();
            String rowClass = "gray";
            long tat = 0;

            if (complaintDate != null) {
                tat = ChronoUnit.DAYS.between(complaintDate.toLocalDate(), LocalDate.now());
                if (tat >= 10) {
                    rowClass = "red";
                } else if (tat >= 5) {
                    rowClass = "yellow";
                } else {
                    rowClass = "green";
                }
            }

            request.setAttribute("tat", tat);
            request.setAttribute("rowClass", rowClass);
        %>

        <tr class="<%= request.getAttribute("rowClass") %>">
            <td><c:out value="${res.complaintID}" /></td>
            <td><%= (complaintDate != null) ? complaintDate.toString() : "N/A" %></td>
            <td><%= (resolveDate != null) ? resolveDate.toString() : "N/A" %></td>
            <td><c:out value="${res.resolvedBy}" /></td>
            <td><c:out value="${res.comments}" /></td>
            <td><%= request.getAttribute("tat") %></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
