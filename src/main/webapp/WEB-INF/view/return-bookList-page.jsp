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
    <h3> booklist</h3>
    <table>
    <tr>
        <th>Borrow ID</th>
        <th>ISBN</th>
        <th>User ID</th>
        <th>Borrowed at</th>
        <th>Return at</th>
        </tr>
<%--    delete link, update link url 변경해야함--%>
    <c:forEach var="borrowbooks" items="${borrowbooks}">
        <c:url var="deleteLink" value="/book/returnOK">
            <c:param name="idBooks" value="${borrowbooks.idBooks}"/>
        </c:url>
        <c:url var="updateLink" value="/book/takeAllReturnBooks">
            <c:param name="idBooks" value="${borrowbooks.idBooks}"/>
        </c:url>
        <tr>
        <div>
            <td><span>${borrowbooks.idborrowBooks}</span></td>
            <td><span>${borrowbooks.idBooks}</span></td>
            <td><span>${borrowbooks.userID}</span></td>
            <td><span>${borrowbooks.borrowedDate} </span></td>
            <td><span>${borrowbooks.expectedReturn}</span></td>
            <td><span>  | 
                <a href="${deleteLink}"
                   onclick="if (!(confirm('반납을 승인하시겠습니까?'))) return false">승인</a>
            </span></td>
        </div>
        </tr>
    </c:forEach>
    </table>
</div>
</script>
</body>
</html>