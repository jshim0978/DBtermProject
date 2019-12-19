<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>대여, 예약</title>
    <style>
        span {
            font: bold 20px/5px Georgia, serif;
            color: maroon;
        }
        .ex1{
            border-radius: 25px;
            border: 2px solid lightseagreen;
            padding:10px;
        }
        .ex2{
            border-radius: 10px;
            border: 1px solid salmon;
            padding:5px;
        }
    </style>

</head>
<body>
<div>
    <span>도서 검색 결과</span>
</div>
<div class="ex1">
    <table>
        <thead>
        <td class="ex1">Isbn</td>
        <td class="ex1">Author</td>
        <td class="ex1">Title</td>

        <td class="ex1">Publisher</td>
        <td class="ex1">Available</td>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <c:url var="borrowLink" value="/book/makeBorrow">
                <c:param name="idBooks" value="${book.idBooks}"/>
                <c:param name="bookName" value="${book.bookName}"/>
            </c:url>
            <c:url var="reservateLink" value="/book/makeReservation">
                <c:param name="idBooks" value="${book.idBooks}"/>
            </c:url>

            <tr>
                <td class="ex2">${book.idBooks}</td>
                <td class="ex2">${book.bookName}</td>
                <td class="ex2">${book.bookAuthor}</td>
                <td class="ex2">${book.bookPublisher}</td>

                <td>

                    <a href="${borrowLink}"
                       onclick="borrowBookButton(event)">대출</a>
                    |
                    <a href="${reservateLink}"
                       onclick="if (!(confirm('예약 하시겠습니까?'))) return false">예약</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <input type="button" onclick="goToSearchPage()" value="검색 화면으로 이동"/>
</div>
<script type="text/javascript" src="/resources/js/search-books.js">
</script>
</body>
</html>