<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Resolve Dashboard</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <style>
        @keyframes fadeInUp {
            from { opacity: 0; transform: translateY(20px); }
            to { opacity: 1; transform: translateY(0); }
        }
        .fade-in-up {
            animation: fadeInUp 1s ease-out both;
        }

        .bokeh {
            position: absolute;
            width: 300px;
            height: 300px;
            background: radial-gradient(circle, rgba(165,180,252,0.4) 0%, rgba(129,140,248,0.2) 100%);
            filter: blur(90px);
            border-radius: 50%;
            animation: move 10s ease-in-out infinite alternate;
        }

        .bokeh:nth-child(1) { top: 10%; left: 10%; }
        .bokeh:nth-child(2) { bottom: 15%; right: 15%; }

        @keyframes move {
            0% { transform: translateY(0) scale(1); }
            100% { transform: translateY(20px) scale(1.1); }
        }

        ::-webkit-scrollbar {
            width: 8px;
        }
        ::-webkit-scrollbar-thumb {
            background: #818cf8;
            border-radius: 10px;
        }
        ::-webkit-scrollbar-thumb:hover {
            background: #6366f1;
        }
    </style>
</head>
<body class="relative min-h-screen flex items-center justify-center bg-gradient-to-br from-indigo-100 to-purple-200 overflow-hidden">

    <!-- Background glow -->
    <div class="bokeh"></div>
    <div class="bokeh"></div>

    <!-- Glassmorphism Card -->
    <div class="backdrop-blur-lg bg-gradient-to-br from-white/70 to-indigo-100/90 border border-white/30 rounded-3xl shadow-2xl p-10 w-full max-w-md z-10 fade-in-up">
        <h1 class="text-3xl font-extrabold text-indigo-800 text-center mb-8 drop-shadow-md">Resolve Dashboard</h1>

        <div class="space-y-6">
            <a href="ResolveAdd.jsp"
               class="block w-full text-center py-3 rounded-xl bg-indigo-500/90 text-white font-semibold shadow-lg hover:bg-indigo-600 transition-all duration-300 hover:scale-105 hover:shadow-xl">
                ✅ Add Resolution
            </a>

            <a href="ResolveShow.jsp"
               class="block w-full text-center py-3 rounded-xl bg-violet-500/90 text-white font-semibold shadow-lg hover:bg-violet-600 transition-all duration-300 hover:scale-105 hover:shadow-xl">
                📋 View All Resolutions
            </a>

            <a href="ResolveSearch.jsp"
               class="block w-full text-center py-3 rounded-xl bg-purple-400/90 text-white font-semibold shadow-lg hover:bg-purple-500 transition-all duration-300 hover:scale-105 hover:shadow-xl">
                🔍 Search Resolution by Complaint ID
            </a>
        </div>
    </div>

</body>
</html>
