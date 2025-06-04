<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Complaint Dashboard</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Inter:wght@400;700&display=swap');

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Inter', sans-serif;
            height: 100vh;
            background: linear-gradient(135deg, #f9c5d1, #a18cd1, #78c6f7);
            background-size: 400% 400%;
            animation: gradientShift 12s ease infinite;
            display: flex;
            justify-content: center;
            align-items: center;
            position: relative;
            overflow: hidden;
        }

        @keyframes gradientShift {
            0% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }

        .blob {
            position: absolute;
            width: 350px;
            height: 350px;
            border-radius: 50%;
            filter: blur(100px);
            opacity: 0.4;
            animation: float 8s ease-in-out infinite;
        }

        .blob1 {
            background: #ffb6c1;
            top: -100px;
            left: -100px;
            animation-delay: 0s;
        }

        .blob2 {
            background: #a18cd1;
            bottom: -100px;
            right: -100px;
            animation-delay: 2s;
        }

        @keyframes float {
            0%, 100% { transform: translateY(0) scale(1); }
            50% { transform: translateY(-30px) scale(1.1); }
        }

        .card {
            position: relative;
            z-index: 10;
            background: rgba(255, 255, 255, 0.85); /* More opaque for better contrast */
            border: 2px solid rgba(255, 255, 255, 0.6);
            border-radius: 25px;
            box-shadow: 0 12px 40px rgba(0, 0, 0, 0.2);
            padding: 50px 40px;
            width: 100%;
            max-width: 420px;
            animation: slideIn 1s ease-out;
        }

        @keyframes slideIn {
            from { opacity: 0; transform: translateY(40px); }
            to { opacity: 1; transform: translateY(0); }
        }

        .card h1 {
            font-size: 30px;
            font-weight: 700;
            color: #4a004e;
            text-align: center;
            margin-bottom: 40px;
            animation: pulse 2s infinite;
        }

        @keyframes pulse {
            0%, 100% { transform: scale(1); }
            50% { transform: scale(1.02); }
        }

        .btn {
            display: block;
            width: 100%;
            padding: 15px 0;
            margin: 15px 0;
            border-radius: 12px;
            font-size: 16px;
            font-weight: bold;
            text-align: center;
            color: #fff;
            text-decoration: none;
            transition: transform 0.3s, box-shadow 0.3s;
        }

        .btn:hover {
            transform: scale(1.05);
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
        }

        .btn.register {
            background: linear-gradient(to right, #ff416c, #ff4b2b);
        }

        .btn.view {
            background: linear-gradient(to right, #6a11cb, #2575fc);
        }

        .btn.search {
            background: linear-gradient(to right, #00c9ff, #92fe9d);
        }
    </style>
</head>
<body>

    <!-- Blurred Animated Background Blobs -->
    <div class="blob blob1"></div>
    <div class="blob blob2"></div>

    <!-- Visually Unique Card -->
    <div class="card">
        <h1>📝 Raise a Complaint</h1>

        <a href="ComplaintAdd.jsp" class="btn register">📝 Register Complaint</a>
        <a href="ComplaintShow.jsp" class="btn view">📋 View All Complaints</a>
        <a href="ComplaintSearch.jsp" class="btn search">🔍 Search Complaint</a>
    </div>

</body>
</html>
