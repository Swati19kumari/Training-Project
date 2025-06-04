<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Management Dashboard</title>

<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    body {
        font-family: 'Poppins', sans-serif;
        background: linear-gradient(135deg, #c2e9fb, #a1c4fd);
        min-height: 100vh;
        display: flex;
        flex-direction: column;
        align-items: center;
        padding: 30px;
    }

    nav {
        width: 100%;
        background-color: #1e3d59;
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
        transition: color 0.3s;
    }

    nav a:hover {
        color: #66d3fa;
    }

    .menu-container {
        background: rgba(255, 255, 255, 0.95);
        padding: 40px;
        border-radius: 20px;
        box-shadow: 0 8px 24px rgba(0, 0, 0, 0.15);
        text-align: center;
        width: 90%;
        max-width: 500px;
    }

    .menu-container h1 {
        font-size: 28px;
        color: #1e3d59;
        margin-bottom: 30px;
        font-weight: 600;
    }

    .menu-button {
        display: block;
        margin: 15px auto;
        padding: 14px;
        width: 85%;
        background: linear-gradient(90deg, #43cea2, #185a9d);
        color: white;
        text-decoration: none;
        font-weight: bold;
        border-radius: 50px;
        font-size: 16px;
        box-shadow: 0 4px 15px rgba(0, 0, 0, 0.15);
        transition: all 0.3s ease;
    }

    .menu-button:hover {
        background: linear-gradient(90deg, #00c6ff, #0072ff);
        transform: scale(1.05);
        box-shadow: 0 6px 20px rgba(0, 0, 0, 0.2);
    }

    @media (max-width: 480px) {
        .menu-container h1 {
            font-size: 24px;
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

<div class="menu-container">
    <h1>Patient Management Dashboard</h1>

    <a href="PatientByDocId.jsf" class="menu-button">Search Patient by Doctor ID</a>
    <a href="PatientById.jsf" class="menu-button">Search Patient by Patient ID</a>
    <a href="AddPatient.jsf" class="menu-button">Add  New Patient </a></div>

</body>
</html>
