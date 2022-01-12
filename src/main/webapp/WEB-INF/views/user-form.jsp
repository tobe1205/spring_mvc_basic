<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<%--
    jsp주석입니다.
    form태그의 action속성에는 양식의 입력데이터를 보낼 서버 URL을 적습니다.
--%>
<form action="/user/confirm" method="POST">
    # 이름 : <input type = "text" name="name"> <br>
    # 키 : <input type = "text" name="height"> <br>
    # 몸무게 : <input type = "text" name="weight"> <br>

    <button type="submit">등록</button>


</form>

</body>

</html>