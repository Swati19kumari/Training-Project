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
            background: linear-gradient(135deg, #e0f7fa, #fefefe);
            margin: 0;
            padding: 40px 20px;
            display: flex;
            justify-content: center;
        }

        .card {
            background-color: #ffffff;
            max-width: 800px;
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

        .form-grid {
            margin-bottom: 30px;
            display: flex;
            align-items: center;
            gap: 15px;
            flex-wrap: wrap;
        }

        .form-grid input[type="text"] {
            padding: 8px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 6px;
            width: 200px;
            background-color: #f5f5f5;
        }

        .form-grid input[type="text"]:focus {
            border-color: #009688;
            background-color: #fff;
            outline: none;
        }

        .form-grid .search-btn {
            background-color: #009688;
            color: white;
            padding: 10px 18px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-weight: bold;
        }

        .form-grid .search-btn:hover {
            background-color: #00796b;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 25px;
        }

        th, td {
            border: 1px solid #ccc;
            padding: 10px;
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
         <h:messages globalOnly="true" style="color:red; font-weight:bold;" />
        
            <h2>Search Doctor by ID</h2>

            <!-- Search Input Section -->
            <div class="form-grid">
                <h:outputLabel for="doctorId" value="Doctor ID:" />
                <h:inputText id="doctorId" value="#{doctorController.doctorId}" />
                <h:commandButton value="Search" action="#{doctorController.searchDoctor}" styleClass="search-btn" />
            </div>

            <!-- Display Doctor Details in a Table -->
            <h:dataTable value="#{doctorController.doctor}" var="doc" rendered="#{not empty doctorController.doctor}">
                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Doctor ID" />
                    </f:facet>
                    <h:outputText value="#{doc.doctorId}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Doctor Name" />
                    </f:facet>
                    <h:outputText value="#{doc.doctorName}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Specialization" />
                    </f:facet>
                    <h:outputText value="#{doc.specialization}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Status" />
                    </f:facet>
                    <h:outputText value="#{doc.isStatus}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Location" />
                    </f:facet>
                    <h:outputText value="#{doc.location}" />
                </h:column>

                <h:column>
                    <f:facet name="header">
                        <h:outputText value="Mobile No" />
                    </f:facet>
                    <h:outputText value="#{doc.mobileNo}" />
                </h:column>
            </h:dataTable>
        </h:form>
    </div>
</body>
</html>
</f:view>
