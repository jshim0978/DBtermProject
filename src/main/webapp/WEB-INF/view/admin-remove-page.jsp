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
    <h3> Book-Remove </h3>

    <form action="removeBook" method="get">
        ISBN : <input type="text" name="idBooks"><br/>

        <br/>
        <input type="submit" value="Remove">
    </form>
</div>

</body>
</html>