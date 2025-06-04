<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Main Menu</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap');

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Inter', sans-serif;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background: linear-gradient(-45deg, #ee7752, #e73c7e, #23a6d5, #23d5ab);
            background-size: 400% 400%;
            animation: gradientBG 12s ease infinite;
        }

        @keyframes gradientBG {
            0% { background-position: 0% 50%; }
            50% { background-position: 100% 50%; }
            100% { background-position: 0% 50%; }
        }

        .menu {
            background: rgba(255, 255, 255, 0.92); /* Increased opacity for contrast */
            border: 2px solid rgba(255, 255, 255, 0.4);
            padding: 60px 40px;
            border-radius: 25px;
            text-align: center;
            color: #333;
            box-shadow: 0 10px 40px rgba(0, 0, 0, 0.25);
            backdrop-filter: blur(10px);
            animation: slideUp 1s ease forwards;
            max-width: 400px;
            width: 90%;
        }

        @keyframes slideUp {
            from { opacity: 0; transform: translateY(40px); }
            to { opacity: 1; transform: translateY(0); }
        }

        .menu h2 {
            font-size: 32px;
            margin-bottom: 40px;
            font-weight: 700;
            letter-spacing: 1px;
            color: #2c003e;
        }

        .menu a {
            display: block;
            margin: 20px 0;
            padding: 18px 0;
            font-size: 18px;
            font-weight: bold;
            border-radius: 30px;
            text-decoration: none;
            color: #fff;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            box-shadow: 0 5px 20px rgba(0, 0, 0, 0.2);
        }

        .menu a:nth-of-type(1) {
            background: linear-gradient(to right, #ff416c, #ff4b2b);
        }

        .menu a:nth-of-type(2) {
            background: linear-gradient(to right, #1d2b64, #f8cdda);
            color: #fff;
        }

        .menu a:hover {
            transform: scale(1.08);
            box-shadow: 0 8px 30px rgba(0, 0, 0, 0.3);
        }
    </style>
</head>
<body>

    <div class="menu">
        <h2>Complaint System Home</h2>
        <a href="ComplaintMenu.jsp">Go to Complaint Menu</a>
        <a href="ResolveMenu.jsp">Go to Resolve Menu</a>
    </div>

</body>
</html>
