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
    <h3> User-Edit </h3>

    <form action="editUser" method="get">
        ID : <input type="text" name="userID" required><br/>
        Pwd : <input type="text" name="userPwd"><br/>
        Name : <input type="text" name="userName"><br/>
        Email : <input type="text" name="userEmail"><br/>
        Phone : <input type="text" name="userPhone"><br/>
        Type : <input type="text" name="userType"><br/>

        <br/>
        <input type="submit" value="Modify">
    </form>
</div>

</body>
</html>