<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Registration</title>
</head>
<body>
<table align="center">
  <tr>
    <td><a href="welcome">Home</a></td>
    <td><a href="logout">Logout</a></td>
  </tr>
</table>
<form:form id="updateForm" modelAttribute="account" action="updateProcess" method="post">
  <table align="center">
    <tr>
      <td><form:label path="name">Name:</form:label></td>
      <td><form:input path="name" name="name" id="name"/></td>
    </tr>
    <tr>
      <td><form:label path="email">Email:</form:label></td>
      <td><form:input path="email" name="email" id="email"/></td>
    </tr>
    <tr>
      <td><form:label path="username">Username:</form:label></td>
      <td><form:input path="username" name="username" id="username" readonly="true"/></td>
    </tr>
    <tr>
      <td><form:label path="password">Password:</form:label></td>
      <td><form:password path="password" name="password" id="password"/></td>
    </tr>
    <tr>
      <td><form:label path="repassword">Re-Enter Password:</form:label></td>
      <td><form:password path="repassword" name="repassword" id="repassword"/></td>
    </tr>
    <tr>
      <td><img src="${pageContext.request.contextPath }/captcha"></td>
      <td><form:input path="captcha" name="captcha" id="captcha"/></td>
    </tr>
    <tr>
      <td></td>
      <td><form:button id="update" name="update">Update</form:button></td>
    </tr>
    <tr></tr>
  </table>
</form:form>
<table align="center">
  <tr>
    <td style="font-style: italic; color: red;">${message}</td>
  </tr>
</table>
</body>
</html>