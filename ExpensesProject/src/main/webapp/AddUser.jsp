<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%> 
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%> 
<f:view>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add User</title>
    <style>
        body {
            background: linear-gradient(to bottom right, #fdfcfb, #e2d1c3);
            font-family: 'Segoe UI', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            overflow: hidden;
            margin: 0;
        }

        .glass {
            background: rgba(255, 255, 255, 0.85);
            backdrop-filter: blur(8px);
            border-radius: 1rem;
            box-shadow: 0 6px 20px rgba(0, 0, 0, 0.15);
            padding: 30px 40px;
            width: 450px;
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

        .error-msg {
            color: red;
            font-size: 0.9rem;
        }
    </style>
</head>
<body>

  <div class="navbar">
    <a href="AddUser.jsp">Add User</a>
    <a href="AddTravelGroup.jsp">Add Group</a>
    <a href="AddGroupMembers.jsp">Add Members</a>
    <a href="split.jsp">Split Expense</a>
    <a href="Menu.jsp">Home</a>
</div>
    <div class="glass">
        <h2>Add User</h2>
        <h:form prependId="false">
            <h:outputLabel value="User Name " />
            <h:inputText id="userName" value="#{users.userName}" />

            <h:outputLabel value="User Email " /> 
            <h:inputText id="email" value="#{users.email}" />
            <h:message for="email" styleClass="error-msg" />

            <br />
            <h:commandButton styleClass="submit-button" action="#{userDao.addUserDao(users)}" value="Add Users" />
        </h:form>
    </div>
</body>
</html>
</f:view>
