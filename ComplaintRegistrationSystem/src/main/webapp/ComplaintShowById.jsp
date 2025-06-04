<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Complaint Details</title>

    <!-- Styling only -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 600px;
            margin: auto;
            background-color: #ffffff;
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #fafafa;
        }
        th, td {
            padding: 12px 15px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #007BFF;
            color: white;
            font-weight: bold;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>🧾 Complaint Details</h2>

    <c:if test="${not empty complaint}">
        <table>
            <tr>
                <th>Complaint ID</th>
                <th>Type</th>
                <th>Description</th>
                <th>Severity</th>
            </tr>
            <tr>
                <td>${complaint.complaintId}</td>
                <td>${complaint.complaintType}</td>
                <td>${complaint.cdescription}</td>
                <td>${complaint.severity}</td>
            </tr>
        </table>
    </c:if>
</div>

</body>
</html>


<!-- Display list of complaints if set -->
<!--<c:if test="${not empty complaintList}">
    <table>
        <tr>
            <th>Complaint ID</th>
            <th>Type</th>
            <th>Description</th>
            <th>Severity</th>
        </tr>
        <c:forEach var="c" items="${complaintList}">
            <tr>
                <td>${c.complaintId}</td>
                <td>${c.complaintType}</td>
                <td>${c.cdescription}</td>
                <td>${c.severity}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>-->

</body>
</html>
