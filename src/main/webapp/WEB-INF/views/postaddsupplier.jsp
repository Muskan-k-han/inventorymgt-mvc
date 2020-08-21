<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<title>Supplier Registeration</title>
</head>
<body>

<h1>Supplier Registeration submits post request</h1>

<form:form method="post" action="/processpostadd" modelAttribute="supplier">

<div>


<label>Name</label>
<form:input path="name"/>

</div>



<input type="submit" value="Create Employee">

</form:form>

</body>
</html>