<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>All Computer</title>
</head>
<body>

<h1>Listing all Computer</h1>


<c:forEach items="${computer}"  var="computer">

Id is :<c:out value="${computer.getId()}"  />

name is :<c:out value="${computer.getItemname()}"  />
Supplier is :<c:out value="${computer.getSupplier().getName()}"  />
DESKSPACE is :<c:out value="${computer.getDeskSpace()}"  />


<br>
</c:forEach>

</body>
</html>