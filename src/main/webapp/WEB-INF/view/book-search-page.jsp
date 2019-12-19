<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>도서 검색</title>
</head>
<body>
<form action="bookSearch" method="GET">
    <div class="ex1">
        <div><span>검색 설정</span><br>
            <input type="radio" name="type" value="isbn" checked>ISBN
            <input type="radio" name="type" value="도서 제목">도서 제목
        </div>

        <div><span>도서명 혹은 ISBN 입력</span><br>
            <input type="text" name="data"/>
            <input type="submit" value="검색"/>
        </div>
        <input type="button" onclick="goToUserMainPage()" value="뒤로가기"/>
    </div>
</form>
<script type="text/javascript" src="/resources/js/search-books.js">
</script>
</body>
</html>