<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h2>서버가 전송한 데이터 : ${ub}</h2>

    <h3>
        저의 이름은 ${ub.userName}이고 <br>
        저의 키는 ${ub.height}cm 입니다.<br>
        저의 몸무게는 ${ub.weight}kg 입니다.<br>

        ** 저의 BMI 지수는 ** <br>
        ${ub.weight/((ub.height/100) * (ub.height/100))} 입니다. <br>


    </h3>

</body>

</html>