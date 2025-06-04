<%@ page import="java.sql.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Resolve Complaint</title>

    <!-- Styling only -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f6f8;
            padding: 30px;
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
        label {
            display: block;
            margin-top: 12px;
            margin-bottom: 6px;
            font-weight: bold;
            color: #333;
        }
        input[type="text"],
        input[type="date"],
        textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
            font-size: 14px;
        }
        textarea {
            resize: vertical;
            height: 100px;
        }
        input[type="submit"] {
            margin-top: 20px;
            width: 100%;
            background-color: #28a745;
            color: white;
            border: none;
            padding: 12px;
            font-size: 16px;
            border-radius: 6px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

<div class="container">
    <form method="post" action="ResolveAdd.jsp">
        <h2>Resolve a Complaint</h2>

        <label for="complaintID">Complaint ID:</label>
        <input type="text" name="complaintID" required />

        <label for="complaintDate">Complaint Date:</label>
        <input type="date" name="complaintDate" required />

        <label for="resolvedBy">Resolved By:</label>
        <input type="text" name="resolvedBy" required />

        <label for="comments">Comments:</label>
        <textarea name="comments"></textarea>

        <input type="submit" value="Submit Resolution" />
    </form>
</div>

<jsp:useBean id="resolveDao" class="com.java.crm.Dao.ResolveDaoImpl" />
<jsp:useBean id="resolve" class="com.java.crm.model.Resolve" />

<%
    String complaintID = request.getParameter("complaintID");
    String complaintDateStr = request.getParameter("complaintDate");
    String resolvedBy = request.getParameter("resolvedBy");
    String comments = request.getParameter("comments");

    if (complaintID != null && complaintDateStr != null && resolvedBy != null) {
        resolve.setComplaintID(complaintID);
        resolve.setResolvedBy(resolvedBy);
        resolve.setComments(comments);

        Date complaintDate = Date.valueOf(complaintDateStr);
        resolve.setComplaintDate(complaintDate);

        resolveDao.addResolve(resolve);
        response.sendRedirect("ResolveShow.jsp");
    }
%>

</body>
</html>
