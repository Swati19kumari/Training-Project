<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Medication-History Dashboard</title>

<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background: linear-gradient(135deg, #dbe9f4, #f1f9ff);
        min-height: 100vh;
        display: flex;
        flex-direction: column;
        align-items: center;
        padding: 30px;
    }

    nav {
        width: 100%;
        background-color: #1f3b57;
        padding: 15px 30px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.15);
        margin-bottom: 40px;
        text-align: left;
    }

    nav a {
        color: white;
        text-decoration: none;
        font-size: 16px;
        font-weight: 500;
        transition: color 0.3s ease;
    }

    nav a:hover {
        color: #48c9b0;
    }

    .dashboard-container {
        background: white;
        padding: 40px;
        border-radius: 15px;
        box-shadow: 0 8px 24px rgba(0, 0, 0, 0.15);
        text-align: center;
        width: 90%;
        max-width: 500px;
    }

    .dashboard-container h1 {
        font-size: 28px;
        color: #1f3b57;
        margin-bottom: 30px;
        font-weight: 600;
    }

    .menu-button {
        display: block;
        margin: 15px auto;
        padding: 14px;
        width: 85%;
        background: linear-gradient(90deg, #007991, #78ffd6);
        color: white;
        text-decoration: none;
        font-weight: bold;
        border-radius: 50px;
        font-size: 16px;
        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.15);
        transition: all 0.3s ease;
    }

    .menu-button:hover {
        background: linear-gradient(90deg, #005f6b, #48c9b0);
        transform: scale(1.05);
        box-shadow: 0 6px 20px rgba(0, 0, 0, 0.25);
    }

    @media (max-width: 480px) {
        .dashboard-container h1 {
            font-size: 22px;
        }

        .menu-button {
            font-size: 14px;
            padding: 12px;
        }
    }
</style>

</head>
<body>

<nav>
    <a href="HomePage.jsf">← Home</a>
</nav>

<div class="dashboard-container">
    <h1>Medication-History Dashboard</h1>

    <a href="ShowMedHistByPatientId.jsf" class="menu-button">
        View Patient Medical History
    </a>

    <a href="AddMedication.jsf" class="menu-button">
        Add Medication
    </a>
</div>

</body>
</html>
