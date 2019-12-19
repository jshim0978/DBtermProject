<%@ page import="org.springframework.ui.Model" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<div id="container">
    <h2> Admin main page </h2>

    <button onclick="location='enrollPage'">enroll</button>
    <button onclick="location='modifyPage'">modify</button>
    <button onclick="location='removePage'">remove</button></br>

    <button onclick="location='returnPage'">approve return</button>

</div>
<script type="text/javascript" src="/resources/js/main-user.js">
</script>
</body>
</html>