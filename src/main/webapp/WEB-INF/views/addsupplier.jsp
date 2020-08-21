<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Supplier Registeration</title>
</head>
<body>

<h1>Supplier Registeration submits get request</h1>

<form method="get" action="/processaddsupplier">

<div>

<label>Name</label>
<input type="text"  name="suppliername">

<label>password</label>
<input type="password"  name="password">
</div>

<input type="submit" value="Create Supplier">

</form>

</body>
</html>