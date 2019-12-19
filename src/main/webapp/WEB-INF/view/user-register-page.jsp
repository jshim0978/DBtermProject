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
    <%--    <%--%>
    <%--        Object obj = session.getAttribute("id");--%>
    <%--        out.print(obj);--%>
    <%--    %>--%>
    <h3> Add User to DB</h3>
    <form action="registerUser" method="get">
        <input type="text" name="userID"><span>user id</span><br/>
        <input type="text" name="userPwd"><span>user pass</span><br/>
        <input type="text" name="userName" maxlength="5"><span>user name</span><br/>
        <input type="text" name="userEmail"><span>user email</span><br/>
        <input type="text" name="userPhone"><span>user phone#</span><br/>
        <input type="text" name="userType" maxlength="3"><span>user type</span><br/>
        <td colspan="2" align="center">
            <input type="submit" value="submit">
            <input type="button" onclick="cancelRegister()" value="cancel">
        </td>
    </form>
</div>
<script type="text/javascript" src="/resources/js/register.js">
</script>
</body>
</html>