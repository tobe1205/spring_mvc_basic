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
        저의 이름은 ${ub.name}이고 <br>
        저의 키는 ${ub.height}입니다.<br>
        저의 몸무게는 ${ub.weight}입니다.<br>

        ** 저의 BMI 지수는 ** <br>
        ${ub.weight / height * height} 입니다. <br>
    </h3>

</body>

</html>