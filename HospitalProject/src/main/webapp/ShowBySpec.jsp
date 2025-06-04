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
            max-width: 1000px;
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
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
        }

        select, input[type="text"] {
            padding: 8px;
            width: 250px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 5px;
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
    </style>
</head>
<body>
    <div class="container">
        <nav>
            <a href="DoctorDashboard.jsf">Doctor Dashboard</a>
            <a href="HomePage.jsf">Home</a>
        </nav>

        <h2>Search by Specialization</h2>

        <h:form>
            <div class="form-group">
                <h:selectOneMenu id="specialization"
                    value="#{doctorController.specializations}" onchange="submit()"
                    valueChangeListener="#{doctorController.doctorSpecializationChanged}">
                    <f:selectItem itemLabel="--Select Specialization--" itemValue="" />
                    <f:selectItem itemLabel="HEART" itemValue="HEART" />
                    <f:selectItem itemLabel="SKIN" itemValue="SKIN" />
                    <f:selectItem itemLabel="GENERAL" itemValue="GENERAL" />
                    <f:selectItem itemLabel="KIDNEY" itemValue="KIDNEY" />
                </h:selectOneMenu>
            </div>

            <div class="form-group">
                <h:outputLabel value="Selected Specialization: " />
                <h:outputText value="#{doctorController.specializations}" />
            </div>

            <h:dataTable id="doctorTable" value="#{doctorController.doctorList}"
                var="doctor" border="0" cellpadding="5" cellspacing="0">

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Doctor ID" />
                    </f:facet>
                    <h:outputText value="#{doctor.doctorId}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Name" />
                    </f:facet>
                    <h:outputText value="#{doctor.doctorName}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Specialization" />
                    </f:facet>
                    <h:outputText value="#{doctor.specialization}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Location" />
                    </f:facet>
                    <h:outputText value="#{doctor.location}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Mobile No" />
                    </f:facet>
                    <h:outputText value="#{doctor.mobileNo}" />
                </h:column>

            </h:dataTable>
        </h:form>
    </div>
</body>
</html>
</f:view>
