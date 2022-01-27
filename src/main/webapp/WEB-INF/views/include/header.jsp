<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- header -->
<header class="common">
    <div class="inner-header">
        <h1 class="logo">
            <a href="/">
                <img src="/img/logo.png" alt="로고이미지">
            </a>
        </h1>
        <h2 class="intro-text">Welcome ${loginUser.name}</h2>
        <a href="#" class="menu-open">
            <span class="menu-txt">MENU</span>
            <span class="lnr lnr-menu"></span>
        </a>
    </div>

    <nav class="gnb">
        <a href="#" class="close">
            <span class="lnr lnr-cross"></span>
        </a>
        <ul>
            <li><a href="/">Home</a></li>
            <li><a href="/score/list">Score App</a></li>
            <li><a href="/board/list">Board</a></li>
            <li><a href="/hello.jsp">Contact</a></li>

            <!-- 로그인 후 페이지 설정 -->
			<c:if test="${loginUser == null}">
                            <li><a href="/login">Login</a></li>
                            <li><a href="/join">Join</a></li>
                        </c:if>

                        <c:if test="${loginUser != null}">
                            <li><a href="#">MyPage</a></li>
                            <li><a href="/sign-out">Logout</a></li>
                        </c:if>

            
             
        </ul>
    </nav>

</header>
<!-- //header -->