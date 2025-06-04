<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Doctor</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to right, #e3f2fd, #ffffff);
            margin: 0;
            padding: 40px 20px;
            display: flex;
            justify-content: center;
        }

        .card {
            background-color: #ffffff;
            max-width: 600px;
            width: 100%;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 10px 18px rgba(0, 123, 255, 0.1);
            border-top: 5px solid #2196f3;
        }

        .card h2 {
            text-align: center;
            margin-bottom: 25px;
            color: #0d47a1;
        }

        .nav-bar {
            display: flex;
            justify-content: space-between;
            margin-bottom: 25px;
        }

        .nav-bar a {
            text-decoration: none;
            color: #1976d2;
            font-weight: bold;
            transition: color 0.3s;
        }

        .nav-bar a:hover {
            color: #0d47a1;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            margin-bottom: 8px;
            color: #333;
            font-weight: bold;
        }

        input[type="text"],
        select {
            width: 100%;
            padding: 10px;
            font-size: 15px;
            border: 1px solid #90caf9;
            border-radius: 6px;
            background-color: #f0f8ff;
            transition: border-color 0.3s;
        }

        input[type="text"]:focus,
        select:focus {
            border-color: #1976d2;
            outline: none;
        }

        .submit-btn {
            text-align: center;
        }

        .submit-btn h\\:commandButton {
            background-color: #2196f3;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .submit-btn h\\:commandButton:hover {
            background-color: #1565c0;
        }
    </style>
</head>
<body>
    <div class="card">
        <div class="nav-bar">
            <a href="DoctorDashboard.jsf">Doctor Dashboard</a>
            <a href="HomePage.jsf">Home</a>
        </div>

        <h2>Add Doctor</h2>

        <h:form>
            <div class="form-group">
                <h:outputLabel for="doctorName" value="Doctor Name" />
                <h:inputText id="doctorName" value="#{doctor.doctorName}" />
            </div>

            <div class="form-group">
                <h:outputLabel for="specialization" value="Specialization" />
                <h:selectOneMenu id="specialization" value="#{doctor.specialization}">
                    <f:selectItem itemLabel="--Select--" itemValue="" />
                    <f:selectItem itemLabel="HEART" itemValue="HEART" />
                    <f:selectItem itemLabel="SKIN" itemValue="SKIN" />
                    <f:selectItem itemLabel="GENERAL" itemValue="GENERAL" />
                    <f:selectItem itemLabel="KIDNEY" itemValue="KIDNEY" />
                </h:selectOneMenu>
            </div>

            <div class="form-group">
                <h:outputLabel for="location" value="Location" />
                <h:inputText id="location" value="#{doctor.location}" />
            </div>

            <div class="form-group">
                <h:outputLabel for="mobileNo" value="Mobile No" />
                <h:inputText id="mobileNo" value="#{doctor.mobileNo}" />
            </div>

            <div class="submit-btn">
                <h:commandButton value="Add Doctor" action="#{doctorController.addDoctors(doctor)}" />
            </div>
            
            <h:messages globalOnly="true" layout="table" style="color:red"/>
        </h:form>
    </div>
</body>
</html>
</f:view>
