<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <%@ include file="../include/static-head.jsp" %>

    <style>
        .board-list {
            width: 70%;
            margin: 0 auto;
        }

        .board-list .articles {
            margin: 250px auto 100px;
            border-collapse: collapse;
            font-size: 1.5em;
            border-radius: 10px;
        }

        .board-list .bottom-section {
            display: flex;
            margin-top: -50px;
        }
        .board-list .bottom-section ul {
            flex: 9;
            display: flex;
            justify-content: center;
        }
        .pagination-custom a {
            color: #444 !important;
        }
        .pagination-custom li.active a {
            background: #333 !important;
            color: #fff !important;
        }

        .board-list .bottom-section .btn-write {
            flex: 1;
            /* background: orange; */
            /* text-align: right;
            position: relative;
            top: -70px; */
        }

        .board-list .amount {
            position: absolute;
            top: 21%;
            right: 16%;            
        }
        .board-list .amount a {
            width: 80px;
        }

        .board-list .search {
            position: absolute;
            top: 21%;
            left: 16%;
        }
        .board-list .search form {
            display: flex;
        }
        .board-list .search form select {
            flex: 1;
            margin-right: 10px;
        }
        .board-list .search form input {
            flex: 3;
        }

    </style>
</head>

<body>

    <div class="wrap">

        <%@ include file="../include/header.jsp" %>

        <div class="board-list">

            <!-- 검색창 영역 -->
            <section class="search">
                <form action="/board/list" method="get">
                    <select id="search-type" class="form-select" name="type">
                        <option value="title">제목</option>
                        <option value="content">내용</option>
                        <option value="writer">작성자</option>
                        <option value="titleContent">제목+내용</option>
                    </select>

                    <input class="form-control" type="text" name="keyword" value="">

                    <button class="btn btn-primary" type="submit">
                        <i class="fas fa-search"></i>
                    </button>
                </form>
            </section>
            
            <div class="amount">
                <a class="btn btn-danger" href="/board/list?amount=10">10</a>
                <a class="btn btn-danger" href="/board/list?amount=20">20</a>
                <a class="btn btn-danger" href="/board/list?amount=30">30</a>
            </div>            
            
            <table class="table table-dark table-striped table-hover articles">
                <tr>
                    <th>번호</th>
                    <th>작성자</th>
                    <th>제목</th>
                    <th>조회수</th>
                    <th>작성시간</th>
                </tr>

                <c:forEach var="b" items="${articles}">
                    <tr>
                        <td>${b.boardNo}</td>
                        <td>${b.writer}</td>
                        <td>
                            ${b.title}
                        </td>
                        <td>${b.viewCnt}</td>
                        <td>
                           <fmt:formatDate value = "${b.regDate}" pattern= "yyyy년 MM월 dd일 a hh:mm"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>

            <div class="bottom-section">

                            <ul class="pagination pagination-lg pagination-custom">

                            </ul>

                            <div class="btn-write">
                                <a class="btn btn-outline-danger btn-lg" href="/board/write">글쓰기</a>
                            </div>
                        </div>

            


        <%@ include file="../include/footer.jsp" %>

    </div>

    <script>
        //상세보기 요청 이벤트
        const $table = document.querySelector(".articles");
        $table.addEventListener('click', e => {
            if (!e.target.matches('.articles td')) return;

            //console.log('tr 클릭됨! - ', e.target);

            let bn = e.target.parentElement.firstElementChild.textContent;
            console.log('글번호: ' + bn);

            location.href = '/board/content?boardNo=' + bn
                + '&pageNum=${pageInfo.page.pageNum}'
                + '&amount=${pageInfo.page.amount}';
        });

        // 현재 위치한 페이지에 active클래스 부여하기
        function appendPageActive() {
            //현재 위치한 페이지 넘버
            const curPage = '${pageInfo.page.pageNum}';
            // console.log('현재페이지:', curPage);

            //ul의 li들을 전부 확인해서 그 텍스트컨텐츠(페이지넘버)가 
            //현재 위치한 페이지 넘버와 같은 li에게 class="active" 부여
            const $ul = document.querySelector('.pagination');
            for (let $li of [...$ul.children]) {
                if ($li.textContent === curPage) {
                    $li.classList.add('active');
                    break;
                }
            }
        }

        //검색 완료 후 select option값 고정
        function fixSearchOption() {
            const $select = document.getElementById('search-type');
            for (let $op of [...$select.children]) {
                if ($op.value === '${pageInfo.page.type}') {
                    $op.setAttribute('selected', 'selected');
                    break;
                }
            }
        }
        appendPageActive();
        fixSearchOption();

    </script>

</body>

</html>