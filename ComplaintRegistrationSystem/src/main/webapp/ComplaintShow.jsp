<%@ page import="com.java.crm.Dao.ComplaintDaoImpl" %>
<%@ page import="com.java.crm.model.Complaint" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    ComplaintDaoImpl dao = new ComplaintDaoImpl();
    List<Complaint> complaintList = dao.getAllComplaints();
    request.setAttribute("complaintList", complaintList);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Complaints</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            margin: 20px;
            padding: 20px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        table {
            width: 90%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }

        th {
            padding: 12px 15px;
            background-color: #007BFF;
            color: white;
            font-weight: bold;
            text-align: center;
        }

        td {
            padding: 0;
            border-bottom: 1px solid #ddd;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        .row-form {
            display: grid;
            grid-template-columns: repeat(6, 1fr);
            width: 100%;
        }

        .row-button {
            border: none;
            background: none;
            width: 100%;
            padding: 12px 15px;
            text-align: center;
            font-family: Arial, sans-serif;
            font-size: 14px;
            cursor: pointer;
            border-right: 1px solid #ddd;
        }

        .row-button:last-child {
            border-right: none;
        }

        .row-button:hover {
            background-color: #f1f1f1;
        }

        form {
            margin: 0;
        }

        p {
            text-align: center;
            color: #555;
            margin-top: 40px;
            font-size: 16px;
        }
    </style>
</head>
<body>

<h2>📋 All Registered Complaints</h2>

<c:if test="${not empty complaintList}">
    <table border="1">
        <tr>
            <th>Complaint ID</th>
            <th>Type</th>
            <th>Description</th>
            <th>Date</th>
            <th>Severity</th>
            <th>Status</th>
        </tr>
        <c:forEach var="c" items="${complaintList}">
            <tr>
                <td colspan="6">
                    <form action="ResolveShow.jsp" method="get">
                        <input type="hidden" name="complaintId" value="${c.complaintId}" />
                        <div class="row-form">
                            <button type="submit" class="row-button">${c.complaintId}</button>
                            <button type="submit" class="row-button">${c.complaintType}</button>
                            <button type="submit" class="row-button">${c.cdescription}</button>
                            <button type="submit" class="row-button">${c.complaintDate}</button>
                            <button type="submit" class="row-button">${c.severity}</button>
                            <button type="submit" class="row-button">${c.status}</button>
                        </div>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${empty complaintList}">
    <p>🚫 No complaints registered.</p>
</c:if>

</body>
</html>
