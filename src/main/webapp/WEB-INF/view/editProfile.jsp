<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<div id="container">

    <h3> edit Profile</h3>
    <form action="changeUserData" method="get">
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

</body>
</html>