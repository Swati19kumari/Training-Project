<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Group Settlement</title>
<script src="https://cdn.tailwindcss.com"></script>
<style>
	body {
		background: linear-gradient(to bottom right, #fdfcfb, #e2d1c3); /* Sand & cream tones */
		overflow: hidden; /* prevent scroll */
		font-family: 'Segoe UI', sans-serif;
	}

	.glass {
		background: rgba(255, 255, 255, 0.85);
		backdrop-filter: blur(5px);
		border-radius: 1rem;
		box-shadow: 0 6px 20px rgba(0, 0, 0, 0.15);
	}

	.section-title {
		font-size: 1.25rem;
		font-weight: 600;
		color: #5c4b51;
		margin-bottom: 0.5rem;
	}
</style>
</head>

  <div class="navbar">
    <a href="AddUser.jsp">Add User</a>
    <a href="AddTravelGroup.jsp">Add Group</a>
    <a href="AddGroupMembers.jsp">Add Members</a>
    <a href="split.jsp">Split Expense</a>
    <a href="Menu.jsp">Home</a>
</div>
<body class="flex items-center justify-center min-h-screen">
	<div class="glass p-6 w-full max-w-4xl space-y-6">

		<!-- Title -->
		<div class="text-center">
			<h2 class="text-3xl font-bold text-[#3b3b3b]"> Group Trip Settlement</h2>
			<p class="text-[#7b6f63] text-sm">Split expenses without hassle</p>
		</div>

		<!-- Group ID Input -->
		<h:form>
			<div class="grid grid-cols-1 gap-4">
				<div>
					<h:outputLabel for="groupId" value="Group ID:" styleClass="block text-[#5c4b51] font-medium mb-1" />
					<h:inputText id="groupId" value="#{userDaoImpl.groupId}" required="true"
						styleClass="w-full p-2 border border-[#c0a18b] rounded-md bg-[#fdf8f3] focus:outline-none focus:ring-2 focus:ring-[#e89f71]" />
				</div>
				<div class="text-center">
					<h:commandButton value="Settle"
						action="#{userDaoImpl.settlement(userDaoImpl.groupId)}"
						styleClass="bg-[#e89f71] text-white px-6 py-2 rounded-full shadow hover:bg-[#cf875f] transition" />
				</div>
			</div>
		</h:form>

		<!-- Summary -->
		<div>
			<h3 class="section-title">📋 Summary</h3>
			<div class="bg-[#fffdfb] border-l-4 border-[#e89f71] p-3 rounded shadow-sm text-sm">
				<p><strong>Advance Collected:</strong> <h:outputText value="#{userDaoImpl.advanceCollected}" /></p>
				<p><strong>Total Expenditure:</strong> <h:outputText value="#{userDaoImpl.totalExpenditure}" /></p>
			</div>
		</div>

		<!-- Receivers -->
		<div class="grid grid-cols-2 gap-4">
			<div>
				<h3 class="section-title">💰 Receivers</h3>
				<div class="rounded border border-[#d6c2b3] bg-[#fefaf6] overflow-hidden text-sm">
					<h:dataTable value="#{userDaoImpl.getPayUser}" var="pay"
						styleClass="min-w-full"
						headerClass="bg-[#f4e7d3] text-[#5c4b51] font-bold"
						rowClasses="bg-white text-[#4a4a4a] border-t">
						<h:column>
							<f:facet name="header">User ID</f:facet>
							<h:outputText value="#{pay.key}" />
						</h:column>
						<h:column>
							<f:facet name="header">Amount</f:facet>
							<h:outputText value="#{pay.value}" />
						</h:column>
					</h:dataTable>
				</div>
			</div>

			<!-- Payers -->
			<div>
				<h3 class="section-title">💸 Payers</h3>
				<div class="rounded border border-[#d6c2b3] bg-[#fefaf6] overflow-hidden text-sm">
					<h:dataTable value="#{userDaoImpl.giveUser}" var="give"
						styleClass="min-w-full"
						headerClass="bg-[#f4e7d3] text-[#5c4b51] font-bold"
						rowClasses="bg-white text-[#4a4a4a] border-t">
						<h:column>
							<f:facet name="header">User ID</f:facet>
							<h:outputText value="#{give.key}" />
						</h:column>
						<h:column>
							<f:facet name="header">Amount</f:facet>
							<h:outputText value="#{give.value}" />
						</h:column>
					</h:dataTable>
				</div>
			</div>
		</div>

	</div>
</body>
</html>
</f:view>
