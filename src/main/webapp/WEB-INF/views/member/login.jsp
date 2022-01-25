<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>

<meta charset="EUC-KR">

<title>Insert title here</title>

</head>

<body>

    <h1>로그인 페이지</h1>



<form action="/loginProcess" method="post">

  <table>

<tr>

        <td>username</td><td><input type="text" name="username" placeholder="username 입력"></td>

      </tr>

      <tr>

        <td>password</td><td><input type="password" name="password" placeholder="비밀번호 입력"></td>

      </tr>

      <tr>


        <td colspan="2" align="right"><button type="submit">로그인</button></td>
        <a href="/signUp">회원가입</a>
        <a href="/find"> 아이디로 찾기</a>

      </tr>

  </table>

</form>

</body>

</html>
