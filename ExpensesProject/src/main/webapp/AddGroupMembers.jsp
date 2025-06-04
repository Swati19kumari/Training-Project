<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Group Member</title>
<style>
body {
	background: linear-gradient(to bottom right, #fdfcfb, #e2d1c3);
	/* Sand & cream tones */
	font-family: 'Segoe UI', sans-serif;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	overflow: hidden;
	margin: 0;
}

/* 🌟 Navbar with styling */
.navbar {
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	background: rgba(255, 255, 255, 0.35);
	backdrop-filter: blur(10px);
	box-shadow: 0 2px 14px rgba(0, 0, 0, 0.12);
	padding: 12px 0;
	z-index: 999;
}

.navbar nav {
	display: flex;
	justify-content: center;
	gap: 20px;
	flex-wrap: wrap;
}

.navbar a {
	text-decoration: none;
	color: #4a3f45;
	font-weight: 600;
	font-size: 15px;
	padding: 10px 18px;
	border-radius: 30px;
	background: rgba(255, 255, 255, 0.6);
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.05);
	transition: all 0.3s ease;
}

.navbar a:hover {
	background: linear-gradient(to right, #ef629f, #eecda3);
	color: white;
	transform: scale(1.05);
}

.glass {
	background: rgba(255, 255, 255, 0.85);
	backdrop-filter: blur(8px);
	border-radius: 1rem;
	box-shadow: 0 6px 20px rgba(0, 0, 0, 0.15);
	padding: 30px 40px;
	width: 400px;
}

.glass h2 {
	text-align: center;
	color: #5c4b51;
	margin-bottom: 20px;
}

label, .ui-outputlabel {
	display: block;
	margin-top: 10px;
	font-weight: 500;
	color: #4a3f45;
}

input[type="text"] {
	width: 100%;
	padding: 8px;
	margin-top: 5px;
	border-radius: 6px;
	border: 1px solid #ccc;
	background: #fffaf6;
}

.submit-button {
	background: linear-gradient(to right, #eecda3, #ef629f);
	color: white;
	border: none;
	padding: 10px 20px;
	margin-top: 20px;
	border-radius: 30px;
	width: 100%;
	cursor: pointer;
	font-size: 1rem;
	transition: all 0.3s ease;
}

.submit-button:hover {
	background: linear-gradient(to right, #ef629f, #eecda3);
}
</style>
</head>
<body>
	<!-- 🔥 Navbar with styling -->
	<header class="navbar">
		<nav>
			<a href="AddUser.jsp">Add User</a> <a href="AddTravelGroup.jsp">Add
				Group</a> <a href="split.jsp">Split Expense</a> <a href="Menu.jsp">Home</a>
		</nav>
	</header>

	<!-- 💼 Add Group Member Form -->
	<div class="glass">
		<h2>Add Group Member</h2>
		<h:form prependId="false">
			<h:outputLabel value="Group Id " />
			<h:inputText id="groupId" value="#{groupMembers.groupId}" />

			<h:outputLabel value="User Id " />
			<h:inputText id="userId" value="#{groupMembers.userId}" />

			<h:outputLabel value="Amount Collected " />
			<h:inputText id="amountCollected"
				value="#{groupMembers.amountCollected}" />

			<br />
			<h:commandButton styleClass="submit-button"
				action="#{userDao.addGroupMembers(groupMembers)}"
				value="Add Members" />
		</h:form>
	</div>
</body>
	</html>
</f:view>
