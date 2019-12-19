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
    <h3>Save Customer</h3>
    <form action="borrow" method="get">
        <input type="text" name="userID"><br/>
        <input type="text" name="userPwd"><br/>

        <input type="submit" value="submit">
    </form>
</div>
<script type="text/javascript" src="/resources/js/main-user.js">
</script>
</body>
</html>