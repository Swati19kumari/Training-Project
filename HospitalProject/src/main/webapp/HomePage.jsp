<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hospital Management System</title>

<!-- Use Font Awesome for icons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />

<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    body {
        font-family: 'Segoe UI', sans-serif;
        background: linear-gradient(to right, #d0e8f2, #f0faff);
        min-height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .container {
        text-align: center;
    }

    .title {
        font-size: 32px;
        color: #1a4c72;
        margin-bottom: 40px;
        font-weight: bold;
    }

    .card-grid {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
        gap: 30px;
        max-width: 850px;
        margin: 0 auto;
    }

    .card {
        background-color: #ffffff;
        padding: 30px;
        border-radius: 20px;
        box-shadow: 0 6px 20px rgba(0, 0, 0, 0.1);
        text-decoration: none;
        color: #1a4c72;
        font-size: 18px;
        font-weight: 600;
        transition: transform 0.3s ease, box-shadow 0.3s ease;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }

    .card i {
        font-size: 50px;
        margin-bottom: 15px;
        color: #0077b6;
    }

    .card:hover {
        transform: translateY(-10px);
        box-shadow: 0 12px 30px rgba(0, 120, 180, 0.3);
        background-color: #eaf6ff;
    }

    @media (max-width: 600px) {
        .title {
            font-size: 24px;
            margin-bottom: 30px;
        }

        .card {
            font-size: 16px;
            padding: 20px;
        }

        .card i {
            font-size: 40px;
        }
    }
</style>
</head>
<body>
    <div class="container">
        <div class="title">Hospital Management System</div>

        <div class="card-grid">
            <a href="DoctorDashboard.jsf" class="card">
                <i class="fas fa-user-md"></i>
                Doctor Dashboard
            </a>
            <a href="PatientDashboard.jsf" class="card">
                <i class="fas fa-procedures"></i>
                Patient Dashboard
            </a>
            <a href="MedHisDashboard.jsf" class="card">
                <i class="fas fa-pills"></i>
                Medication History
            </a>
        </div>
    </div>
</body>
</html>
