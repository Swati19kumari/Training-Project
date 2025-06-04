<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resolve Details</title>

    <!-- Styling only -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f5f8;
            padding: 30px;
        }

        h2 {
            text-align: center;
            color: #2c3e50;
            margin-bottom: 25px;
        }

        table {
            width: 80%;
            margin: 0 auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.05);
        }

        th, td {
            padding: 12px 16px;
            border: 1px solid #ccc;
            text-align: center;
        }

        th {
            background-color: #3498db;
            color: white;
        }

        td {
            background-color: #ecf0f1;
        }

        p {
            font-size: 18px;
            color: #c0392b;
        }
    </style>
</head>
<body>

<h2>Resolve Details</h2>

<c:if test="${not empty resolve}">
    <table>
        <tr>
            <th>Complaint ID</th>
            <th>Complaint Date</th>
            <th>Resolve Date</th>
            <th>Resolved By</th>
            <th>Comments</th>
            <th>TAT (Days)</th>
        </tr>
        <tr>
            <td>${resolve.complaintID}</td>
            <td>${resolve.complaintDate}</td>
            <td>${resolve.resolveDate}</td>
            <td>${resolve.resolvedBy}</td>
            <td>${resolve.comments}</td>
            <td>${resolve.tat}</td>
        </tr>
    </table>
</c:if>

<c:if test="${empty resolve}">
    <center><p>No resolve record found for the given Complaint ID.</p></center>
</c:if>

</body>
</html>
