<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="../layouts/header.jsp" %>

<script>
    // $(document).ready(function () {
        // let actionForm = $('#actionForm');
        //
        // $('a.page-link').on('click', function (e) {
        //     e.preventDefault();	// 해당 태그의 디폴트 액션 실행 막음
        //     actionForm.find('input[name="pageNum"]')
        //         .val($(this).attr('href'));
        //     actionForm.submit();
        // });
        //
        // $('.move').on('click', function (e) {
        //     e.preventDefault();
        //     actionForm.append('<input type="hidden" name="bno"/>');
        //     actionForm.find('input[name="bno"]')
        //         .val($(this).attr('href'));
        //     actionForm.attr('action', '/board/get');
        //     actionForm.submit();
        // });

    });
</script>

<h1 class="page-header my-5">
    <i class="fas fa-list"></i> 게시글 목록
</h1>

<div class="d-flex justify-content-between align-items-center my-4">
    <div class=" ">
        총 ${pageMaker.total} 건
        ( ${pageMaker.cri.pageNum} 페이지 / 총 ${pageMaker.totalPage } 페이지)
    </div>
    <div>
        <form id="searchForm" method="get" class="d-flex">
            <input type="hidden" name="pageNum" value="1">
            <select name="type" class="form-select rounded-0 ml-1" >
                <option value="" ${pageMaker.cri.type == null ? 'selected' : ''}>
                    -- 검색대상선택 --</option>
                <option value="T" ${pageMaker.cri.type eq 'T' ? 'selected' : ''}>
                    제목</option>
                <option value="C" ${pageMaker.cri.type eq 'C' ? 'selected' : ''}>
                    내용</option>
                <option value="W" ${pageMaker.cri.type eq 'W' ? 'selected' : ''}>
                    작성자</option>
                <option value="TC" ${pageMaker.cri.type eq 'TC' ? 'selected' : ''}>
                    제목+내용</option>
                <option value="TW" ${pageMaker.cri.type eq 'TW' ? 'selected' : ''}>
                    제목+작성자</option>
                <option value="TWC" ${pageMaker.cri.type eq 'TWC' ? 'selected' : ''}>
                    제목+내용+작성자</option>
            </select>
            <div class="input-group">
                <input type="text" name="keyword" class="form-control rounded-0" />
                <button type="submit" class="btn btn-success rounded-0" >
                    <i class="fa-solid fa-magnifying-glass"></i> 검색</button>
            </div>
        </form>
    </div>
</div>
<table class="table table-striped table-hover">
    <thead>
    <tr>
        <th style="width: 60px">No</th>
        <th>제목</th>
        <th style="width: 100px">작성자</th>
        <th style="width: 130px">등록일</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="board" items="${list}">
            <tr>
                <td>${board.bno}</td>
                <td><a class="move" href="${cri.getLinkWithBno('get',board.bno)}">${board.title}</a></td>
                <td>${board.writer}</td>
                <td><fmt:formatDate pattern="yyyy-MM-dd"
                                    value="${board.regDate}"/></td>
            </tr>
        </c:forEach>
    </tbody>

</table>


<div class="text-right">
    <a href="register" class="btn btn-primary"> <i class="far fa-edit"></i>
        글쓰기
    </a>
</div>

<ul class="pagination justify-content-center">
    <c:if test="${pageMaker.cri.pageNum > 1}">
        <li class="page-item">
            <a class="page-link" href="${cri.getLink(1)}">
                <i class="fa-solid fa-backward-step"></i>
            </a>
        </li>
    </c:if>

    <c:if test="${pageMaker.prev}">
        <li class="page-item">
            <a class="page-link" href="${cri.getLink(pageMaker.startPage-1)}">
                <i class="fa-solid fa-angle-left"></i>
            </a>
        </li>
    </c:if>


    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="num">
        <li class="page-item ${ pageMaker.cri.pageNum == num ? 'active' : '' }">
            <a class="page-link" href="${cri.getLink(num)}">
                    ${num}</a>
        </li>
    </c:forEach>


    <c:if test="${pageMaker.next}">
        <li class="page-item">
            <a class="page-link" href="${cri.getLink(pageMaker.endPage+1)}">
                <i class="fa-solid fa-angle-right"></i>
            </a>
        </li>
    </c:if>

    <c:if test="${pageMaker.cri.pageNum < pageMaker.totalPage}">
        <li class="page-item">
            <a class="page-link" href="${cri.getLink(pageMaker.totalPage)}">
                <i class="fa-solid fa-forward-step"></i>
            </a>
        </li>
    </c:if>
</ul>

<%--<form id="actionForm" action="/board/list" method="get">--%>
<%--    <input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}"/>--%>
<%--    <input type="hidden" name="amount" value="${pageMaker.cri.amount}"/>--%>
<%--    <input type="hidden" name="type" value="${pageMaker.cri.type}"/>--%>
<%--    <input type="hidden" name="keyword" value="${pageMaker.cri.keyword}"/>--%>
<%--</form>--%>




<%@include file="../layouts/footer.jsp" %>
