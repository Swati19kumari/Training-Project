<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Doctor Details</title>
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

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 25px;
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

        .form-grid {
            margin-top: 20px;
            display: grid;
            grid-template-columns: auto auto auto;
            gap: 10px;
            align-items: center;
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
        }

        input[type="submit"]:hover {
            background-color: #00695c;
        }
    </style>
</head>
<body>
    <div class="container">
        <nav>
            <a href="HomePage.jsf">Home</a>
            <a href="PatientDashboard.jsf">Patient Dashboard</a>
        </nav>

        <h2>Show Patient by ID</h2>

        <h:form>
        <h:messages globalOnly="true" style="color:red; font-weight:bold;" />
        
            <div class="form-grid">
                <h:outputLabel for="patientId" value="Patient ID:" />
                <h:inputText id="patientId" value="#{doctorController.patientId}" />
                <h:commandButton value="Search" action="#{doctorController.ShowPatientById}" />
            </div>

            <h:dataTable value="#{doctorController.patient}" var="patient"
                         border="0" rendered="#{not empty doctorController.patient}">

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Patient Name" />
                    </f:facet>
                    <h:outputText value="#{patient.patientName}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Date of Birth" />
                    </f:facet>
                    <h:outputText value="#{patient.dateOfBirth}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Patient ID" />
                    </f:facet>
                    <h:outputText value="#{patient.patientId}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Doctor ID" />
                    </f:facet>
                    <h:outputText value="#{patient.doctor.doctorId}" />
                </h:column>
            </h:dataTable>
        </h:form>
    </div>
</body>
</html>
</f:view>
