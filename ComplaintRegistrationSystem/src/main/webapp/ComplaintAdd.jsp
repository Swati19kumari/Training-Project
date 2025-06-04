<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Complaint Registration</title>

    <!-- Basic UI Styling (No functionality change) -->
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 20px;
        }
        .form-card {
            background: #ffffff;
            max-width: 500px;
            margin: auto;
            padding: 25px 30px;
            border-radius: 12px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        .form-card h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
        label {
            display: block;
            margin-top: 15px;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"],
        select {
            width: 100%;
            padding: 8px 12px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            width: 100%;
            margin-top: 20px;
            padding: 10px;
            background-color: #4CAF50;
            border: none;
            color: white;
            font-size: 16px;
            border-radius: 6px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

    <form method="post" action="ComplaintAdd.jsp">
        <div class="form-card">
            <h2>📝 Register a Complaint</h2>

            <label for="complaintType">Complaint Type:</label>
            <input type="text" name="complaintType" value="${complaint.complaintType}" />

            <label for="description">Complaint Description:</label>
            <input type="text" name="cdescription" value="${complaint.cdescription}" />

            <label for="severity">Severity:</label>
            <select name="severity">
                <option value="LOW" ${complaint.severity == 'LOW' ? 'selected' : ''}>Low</option>
                <option value="MEDIUM" ${complaint.severity == 'MEDIUM' ? 'selected' : ''}>Medium</option>
                <option value="HIGH" ${complaint.severity == 'HIGH' ? 'selected' : ''}>High</option>
            </select>

            <input type="submit" value="Submit Complaint" />
        </div>
    </form>

    <!-- Bean Declarations -->
    <jsp:useBean id="complaintDao" class="com.java.crm.Dao.ComplaintDaoImpl" />
    <jsp:useBean id="complaint" class="com.java.crm.model.Complaint" />
    <jsp:setProperty property="*" name="complaint" />

    <c:if test="${not empty param.complaintType and not empty param.cdescription}">
        <% complaintDao.addComplaint(complaint); %>
        <jsp:forward page="ComplaintShow.jsp" />
    </c:if>

</body>
</html>
