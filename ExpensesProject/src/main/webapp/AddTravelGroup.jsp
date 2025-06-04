<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%> 
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%> 
<f:view>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Travel Group</title>
    <style>
        body {
            background: linear-gradient(to bottom right, #fdfcfb, #e2d1c3); /* Soft sand tone */
            font-family: 'Segoe UI', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            overflow: hidden;
            margin: 0;
            padding-top: 80px; /* Space between navbar and card */
        }

        /* Navbar Styling */
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
            font-size: 16px; /* Increased font size */
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

        /* Glass effect card */
        .glass {
            background: rgba(255, 255, 255, 0.85);
            backdrop-filter: blur(8px);
            border-radius: 1rem;
            box-shadow: 0 6px 20px rgba(0, 0, 0, 0.15);
            padding: 30px 30px;
            width: 400px; /* Adjusted card width */
            max-width: 80%;
        }

        .glass h2 {
            text-align: center;
            color: #5c4b51;
            margin-bottom: 20px;
            font-size: 1.5rem; /* Increased font size */
        }

        label, .ui-outputlabel {
            display: block;
            margin-top: 12px; /* Added spacing for better alignment */
            font-weight: 500;
            color: #4a3f45;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px; /* Increased padding for input */
            margin-top: 8px;
            border-radius: 6px;
            border: 1px solid #ccc;
            background: #fffaf6;
            font-size: 1rem; /* Adjusted input font size */
        }

        /* Submit Button Styling */
        .submit-button {
            background: linear-gradient(to right, #eecda3, #ef629f);
            color: white;
            border: none;
            padding: 12px 20px;
            margin-top: 20px;
            border-radius: 30px;
            width: 100%;
            cursor: pointer;
            font-size: 1.1rem; /* Increased font size for button */
            transition: all 0.3s ease;
        }

        .submit-button:hover {
            background: linear-gradient(to right, #ef629f, #eecda3);
        }
    </style>
</head>
<body>

  <!-- Navbar -->
  <header class="navbar">
      <nav>
          <a href="AddUser.jsp">Add User</a>
          <a href="AddTravelGroup.jsp">Add Group</a>
          <a href="AddGroupMembers.jsp">Add Members</a>
          <a href="split.jsp">Split Expense</a>
          <a href="Menu.jsp">Home</a>
      </nav>
  </header>

  <!-- Glass effect card -->
  <div class="glass">
      <h2>Create Travel Group</h2>
      <h:form prependId="false">
          <h:outputLabel value="Created By " />
          <h:inputText id="createdBy" value="#{travelGroup.createdBy}" />

          <h:outputLabel value="Group Name " /> 
          <h:inputText id="groupName" value="#{travelGroup.groupName}" />

          <h:outputLabel value="Start Date " /> 
          <h:inputText id="startDate" value="#{travelGroup.startDate}">
              <f:convertDateTime pattern="yyyy-MM-dd" />
          </h:inputText>

          <h:outputLabel value="End Date " /> 
          <h:inputText id="endDate" value="#{travelGroup.endDate}">
              <f:convertDateTime pattern="yyyy-MM-dd" />
          </h:inputText>

          <h:outputLabel value="Initial Amount " /> 
          <h:inputText id="initialAmount" value="#{travelGroup.initialAmount}" />

          <br />
          <h:commandButton styleClass="submit-button" action="#{userDao.addGroup(travelGroup)}" value="Add Group" />
      </h:form>
  </div>

</body>
</html>
</f:view>
