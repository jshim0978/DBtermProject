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
    <h3> Book-Enroll </h3>

    <form action="enrollBook" method="get">
        ISBN : <input type="text" name="idBooks"><br/>
        Author : <input type="text" name="bookAuthor"><br/>
        Name : <input type="text" name="bookName"><br/>
        Publisher : <input type="text" name="bookPublisher"><br/>

        <br/>
        <input type="submit" value="Enroll">
    </form>
</div>


</body>
</html>