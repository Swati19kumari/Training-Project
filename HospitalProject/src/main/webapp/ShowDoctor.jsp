<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Show Doctors</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to right, #e0f7fa, #ffffff);
            margin: 0;
            padding: 40px 20px;
            display: flex;
            justify-content: center;
        }

        .card {
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

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
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
    <div class="card">
        <nav>
            <a href="DoctorDashboard.jsf">Doctor Dashboard</a>
            <a href="HomePage.jsf">Home</a>
        </nav>

        <h:form>
            <h2>
                <h:outputText value="Doctor Records" />
            </h2>

            <h:dataTable value="#{doctorController.showDoctor()}" var="doc"
                border="0" cellpadding="5" cellspacing="0">

                <h:column>
                    <f:facet name="header">
                        <h:outputLabel value="Doctor ID" />
                    </f:facet>
                    <h:outputText value="#{doc.doctorId}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputLabel value="Doctor Name" />
                    </f:facet>
                    <h:outputText value="#{doc.doctorName}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputLabel value="Specialization" />
                    </f:facet>
                    <h:outputText value="#{doc.specialization}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputLabel value="Location" />
                    </f:facet>
                    <h:outputText value="#{doc.location}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputLabel value="Mobile No" />
                    </f:facet>
                    <h:outputText value="#{doc.mobileNo}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputLabel value="Status" />
                    </f:facet>
                    <h:outputText value="#{doc.isStatus}" />
                </h:column>

            </h:dataTable>
        </h:form>
    </div>
</body>
</html>
</f:view>
