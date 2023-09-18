<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="../layouts/header.jsp" %>

<script src="/resources/js/search.js">

</script>

<h1>100대 관광지</h1>
<div>
    <form id="searchForm" method="get" class="d-flex">
        <input type="hidden" name="pageNum" value="1">
        <select name="type" class="form-select rounded-0 ml-1">
            <option value="" ${pageMaker.cri.type == null ? 'selected' : ''}>
                -- 검색대상선택 --
            </option>
            <option value="R" ${pageMaker.cri.type eq 'R' ? 'selected' : ''}>
                권역
            </option>
            <option value="T" ${pageMaker.cri.type eq 'T' ? 'selected' : ''}>
                제목
            </option>
            <option value="D" ${pageMaker.cri.type eq 'D' ? 'selected' : ''}>
                내용
            </option>
            <option value="TD" ${pageMaker.cri.type eq 'TD' ? 'selected' : ''}>
                제목+내용
            </option>
            <option value="TR" ${pageMaker.cri.type eq 'TR' ? 'selected' : ''}>
                제목+권역
            </option>
            <option value="TRD" ${pageMaker.cri.type eq 'TRD' ? 'selected' : ''}>
                권역+제목+내용
            </option>
        </select>
        <div class="input-group">
            <input type="text" name="keyword" class="form-control rounded-0"/>
            <button type="submit" class="btn btn-success rounded-0">
                <i class="fa-solid fa-magnifying-glass"></i> 검색
            </button>
        </div>
    </form>
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
        <c:forEach var="travel" items="${list}">
            <tr>
                <td>${travel.no}</td>
                <td>${travel.region}</td>
                <td><a href="#">${travel.title}</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<div class="text-right">
    <a href="register" class="btn btn-primary"> <i class="far fa-edit"></i>
        추가
    </a>
</div>

<%@ include file="../common/pagination.jsp"%>

<%@ include file="../layouts/footer.jsp" %>
