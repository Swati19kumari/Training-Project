<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Medication History</title>
  <style>
    body {
      font-family: 'Segoe UI', sans-serif;
      background: linear-gradient(to right, #e0f7fa, #ffffff);
      margin: 0;
      padding: 40px 20px;
      display: flex;
      justify-content: center;
    }

    .container {
      background-color: #ffffff;
      max-width: 900px;
      width: 100%;
      padding: 30px 40px;
      border-radius: 12px;
      box-shadow: 0 8px 16px rgba(0, 150, 136, 0.2);
      border-top: 5px solid #009688;
    }

    nav {
      display: flex;
      justify-content: space-between;
      margin-bottom: 20px;
    }

    nav a {
      text-decoration: none;
      color: #009688;
      font-weight: bold;
      font-size: 15px;
      transition: color 0.3s ease;
    }

    nav a:hover {
      color: #004d40;
    }

    h2 {
      text-align: center;
      margin-bottom: 30px;
      color: #00796b;
    }

    .form-group {
      display: flex;
      flex-direction: column;
      gap: 10px;
      margin-bottom: 20px;
    }

    input[type="text"] {
      padding: 8px;
      font-size: 14px;
      border-radius: 5px;
      border: 1px solid #ccc;
    }

    input[type="submit"], .btn {
      background-color: #009688;
      color: white;
      padding: 8px 16px;
      font-size: 14px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      width: fit-content;
    }

    input[type="submit"]:hover {
      background-color: #00695c;
    }

    .messages {
      color: red;
      font-weight: bold;
      margin-bottom: 15px;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }

    th, td {
      border: 1px solid #ccc;
      padding: 12px;
      text-align: center;
    }

    th {
      background-color: #e0f2f1;
      color: #004d40;
    }

    td {
      background-color: #f9f9f9;
    }

    center {
      display: flex;
      justify-content: center;
    }
  </style>
</head>
<body>

  <h:form>

    <!-- Navbar -->
    <div>
      <nav>
        <a href="HomePage.jsf">Home</a>
        <a href="MedHisDashboard.jsf">Medication Dashboard</a>
      </nav>
    </div>

    <!-- Form Content -->
    <div class="container">
      <h2>Add Medical History</h2>

      <div class="form-group">
        <h:outputLabel for="patientId" value="Patient Id" />
        <h:inputText id="patientId" value="#{med.patient.patientId}" />
      </div>

      <div class="form-group">
        <h:outputLabel for="medicines" value="Medicines" />
        <h:inputText id="medicines" value="#{med.medicines}" />
      </div>

      <div class="form-group">
        <h:outputLabel for="tests" value="Tests" />
        <h:inputText id="tests" value="#{med.tests}" />
      </div>

      <h:commandButton value="Add Medical History"
                       action="#{doctorController.addMedicalHistoryController}"
                       styleClass="btn" />

    </div>
  </h:form>

</body>
</html>
</f:view>
