<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


  <h:form>

    <!-- Navbar -->
    <div>
      <nav>
        <a href="HomePage.jsf">Home</a>
        <a href="PatientDashboard.jsf">Patient Dashboard</a>
      </nav>
    </div>

    <!-- Form Content -->
    <div class="container">
      <h2>Add Patient</h2>

      <div class="form-group">
        <h:outputLabel for="patientId" value="Patient Id" />
        <h:inputText id="patientId" value="#{patient.patientId}" />
      </div>

      <div class="form-group">
        <h:outputLabel for="patientName" value="Patient Name" />
        <h:inputText id="patientName" value="#{patient.patientName}" />
      </div>

      <div class="form-group">
        <h:outputLabel for="dateOfBirth" value="DateOfBirth" />
        <h:inputText id="dateOfBirth" value="#{patient.dateOfBirth}" />
      </div>
      
      <div class="form-group">
        <h:outputLabel for="doctorId" value="DoctorId" />
        <h:inputText id="doctorId" value="#{patient.doctor.doctorId}" />
      </div>

      <h:commandButton value="Add Patient"
                       action="#{doctorController.addPatientController}"
                       styleClass="btn" />

    </div>
  </h:form>

</body>
</html>