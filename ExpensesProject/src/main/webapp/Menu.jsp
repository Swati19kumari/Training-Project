<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Travel Expense Manager - Menu</title>
<script src="https://cdn.tailwindcss.com"></script>
<style>
	body {
		background: linear-gradient(to bottom right, #D4C7F9, #A9E4D0); /* Soft lavender gradient */
		font-family: 'Segoe UI', sans-serif;
		min-height: 100vh;
		display: flex;
		justify-content: center;
		align-items: center;
		flex-direction: column;
	}

	.container {
		width: 95%;
		max-width: 1200px;
		margin-top: 30px;
	}

	.card {
		background-color: #F5E0D2; /* Soft peach */
		box-shadow: 0 6px 25px rgba(0, 0, 0, 0.1);
		border-radius: 1rem;
		padding: 20px;
		margin: 15px;
		text-align: center;
		cursor: pointer;
		transition: transform 0.3s ease, box-shadow 0.3s ease;
		width: 250px; /* Reduced width for better fit */
	}

	.card:hover {
		transform: translateY(-10px);
		box-shadow: 0 12px 30px rgba(0, 0, 0, 0.15);
	}

	.card h3 {
		font-size: 1.25rem;
		color: #3A3A3A;
		font-weight: bold;
		margin-bottom: 15px;
	}

	.card p {
		color: #6A6A6A;
		font-size: 0.95rem;
		margin-bottom: 20px;
	}

	.card-button {
		background: linear-gradient(135deg, #F3A7B5, #F5C3D4); /* Soft gradient */
		color: white;
		padding: 12px 25px;
		border-radius: 30px;
		font-size: 1.1rem;
		box-shadow: 0 6px 15px rgba(0, 0, 0, 0.1);
		transition: all 0.3s ease;
		cursor: pointer;
		border: none;
	}

	.card-button:hover {
		background: linear-gradient(135deg, #F79D7F, #FBC8A9); /* Darker gradient */
		box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
		transform: translateY(-5px);
	}

	.card-container {
		display: flex;
		flex-wrap: wrap;
		justify-content: space-evenly; /* Center and space out the cards evenly */
		align-items: flex-start; /* Align items at the top */
		gap: 20px;
		margin-top: 20px;
	}

	.card-button-container {
		margin-top: 15px;
	}

	/* Ensure cards fit within smaller screen widths */
	@media (max-width: 768px) {
		.card {
			width: 200px; /* Adjust width on smaller screens */
		}
	}

	/* Prevent scrolling */
	html, body {
		overflow: hidden;
	}
</style>
</head>
<body>

	<div class="container text-center">
		<h1 class="text-4xl font-bold text-[#3A3A3A] mb-8">Welcome to Travel Expense Manager</h1>
		<div class="card-container">
			
			<!-- Add Daily Expense -->
			<div class="card">
				<h3>Add Daily Expense</h3>
				<p>Record your daily expenses for the travel group.</p>
				<div class="card-button-container">
					<a href="AddDailyExpense.jsp">
						<button class="card-button">
							 Record Expense
						</button>
					</a>
				</div>
			</div>
			
			<!-- Add Group Members -->
			<div class="card">
				<h3>Add Group Members</h3>
				<p>Add new members to your travel group.</p>
				<div class="card-button-container">
					<a href="AddGroupMembers.jsp">
						<button class="card-button">
							 Add Members
						</button>
					</a>
				</div>
			</div>

			<!-- Add Travel Group -->
			<div class="card">
				<h3>Add Travel Group</h3>
				<p>Create a new travel group for managing expenses.</p>
				<div class="card-button-container">
					<a href="AddTravelGroup.jsp">
						<button class="card-button">
							Create Group
						</button>
					</a>
				</div>
			</div>

			<!-- Add User -->
			<div class="card">
				<h3>Add User</h3>
				<p>Add new users who will participate in the system.</p>
				<div class="card-button-container">
					<a href="AddUser.jsp">
						<button class="card-button">
							 Add User
						</button>
					</a>
				</div>
			</div>

			<!-- Split Expense -->
			<div class="card">
				<h3>Split Expense</h3>
				<p>Split expenses among travel group members.</p>
				<div class="card-button-container">
					<a href="split.jsp">
						<button class="card-button">
							 Split Expense
						</button>
					</a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
</f:view>
