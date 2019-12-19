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
    <h1> Admin main page </h1>

    <!--
        <button onclick="location='/book/allBookListPage'">book list</button></br>
        <button onclick="location='modifyPage'">modify</button>
        <button onclick="location='removePage'">remove</button></br>
        <button onclick="location='returnPage'">approve return</button>
    -->

    <h3> Books
        <button onclick="location='enrollPage'">Add new book</button>
        <button onclick="location='/book/allReturnListPage'">Check return list</button>
        <button onclick="location='/book/search'">Search</button>
    </h3>

<%--    delete link, update link url 변경해야함--%>
<table style="border:1px solid">
    <tr>
    <th>ISBN</th>
    <th>Title</th>
    <th>Author</th>
    <th>Publisher</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <c:url var="deleteLink" value="/admin/removeBook">
            <c:param name="idBooks" value="${book.idBooks}"/>
        </c:url>
        <c:url var="updateLink" value="/admin/modifyPage">
            <c:param name="idBooks" value="${book.idBooks}"/>
        </c:url>
        <tr>
            <div>
                <td> <span>${book.idBooks}</span> </td>
                <td> <span>${book.bookName} </span> </td>
                <td> <span>${book.bookAuthor}</span> </td>
                <td> <span>${book.bookPublisher}</span> </td>
                <span>
                    <td> <a href="${deleteLink}"
                       onclick="if (!(confirm('책을 목록에서 삭제 하시겠습니까?'))) return false">제거</a> </td>
                    <td> <a href="${updateLink}"
                       onclick="if (!(confirm('책 정보 수정 화면으로 넘어가시겠습니까?'))) return false">수정</a> </td>
                </span>
            </div>
        </tr>
    </c:forEach>
    </table>
</div>
<script type="text/javascript" src="/resources/js/main-user.js">
</script>
</body>
</html>