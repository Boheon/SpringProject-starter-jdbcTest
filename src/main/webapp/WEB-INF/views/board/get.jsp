<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="../layouts/header.jsp" %>

<script>
    $(document).ready(function () {

        // $('.list').click(function () {
        //     document.forms.listForm.submit();
        // });
        //
        // $('.modify').click(function () {
        //     document.forms.modifyForm.submit();
        // });

        $('.remove').click(function () {
            if (!confirm('정말 삭제할까요?')) return;
            document.forms.removeForm.submit();
        });

    });

    // 필수요소 체크
    let searchForm = $('#searchForm');
    $('#searchForm button').on('click', function (e) {
        if (!searchForm.find('option:selected').val()) {
            alert('검색종류를 선택하세요');
            return false;
        }
        if (!searchForm.find('input[name="keyword"]').val()) {
            alert('키워드를 입력하세요');
            return false;
        }
        searchForm.find('input[name="pageNum"]').val('1');
        e.preventDefault();
        searchForm.submit();
    });

</script>

<h1 class="page-header"><i class="far fa-file-alt"></i> ${board.title}</h1>

<div class="d-flex justify-content-between">
    <div><i class="fas fa-user"></i> ${board.writer}</div>
    <div><i class="fas fa-clock"></i>
        <fmt:formatDate pattern="yyyy-MM-dd" value="${board.regDate}"/>
    </div>
</div>

<hr>
<div>
    ${board.content}
</div>

<div class="mt-4">
    <a href="${cri.getLink('list')}" class="btn btn-primary list">
        <i class="fas fa-list"></i> 목록</a>
    <a href="${cri.getLinkWithBno('modify', board.bno)}" class="btn btn-primary modify">
        <i class="far fa-edit"></i> 수정</a>
    <a href="#" class="btn btn-danger remove">
        <i class="fas fa-trash-alt"></i> 삭제</a>
</div>

<%--<form id="listForm" action="/board/list" method="get">--%>
<%--    <input type="hidden" name="pageNum" value="${cri.pageNum}"/>--%>
<%--    <input type="hidden" name="amount" value="${cri.amount}"/>--%>
<%--    <input type="hidden" name="type" value="${pageMaker.cri.type}"/>--%>
<%--    <input type="hidden" name="keyword" value="${pageMaker.cri.keyword}"/>--%>
<%--</form>--%>

<%--<form id="modifyForm" action="/board/modify" method="get">--%>
<%--    <input type="hidden" id="bno" name="bno" value="${board.bno}"/>--%>
<%--    <input type="hidden" name="pageNum" value="${cri.pageNum}"/>--%>
<%--    <input type="hidden" name="amount" value="${cri.amount}"/>--%>
<%--    <input type="hidden" name="type" value="${pageMaker.cri.type}"/>--%>
<%--    <input type="hidden" name="keyword" value="${pageMaker.cri.keyword}"/>--%>
<%--</form>--%>

<form action="remove" method="post" name="removeForm">
    <input type="hidden" name="bno" value="${board.bno}"/>
    <input type="hidden" name="pageNum" value="${cri.pageNum}"/>
    <input type="hidden" name="amount" value="${cri.amount}"/>
    <input type="hidden" name="type" value="${pageMaker.cri.type}"/>
    <input type="hidden" name="keyword" value="${pageMaker.cri.keyword}"/>
</form>

<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=cc0a7b1e9e5540c4e6b8cf4518b1062d" &libraries="services"></script>
<script>
    let mapContainer = document.getElementById('map');
    //  지도 제어 코딩
    let mapContainer = document.getElementById('map'); // 지도를 표시할 div
    let mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 중심좌표
        level: 3 // 지도의 확대 레벨
    };
    let map = new kakao.maps.Map(mapContainer, mapOption);

    // 마커가 표시될 위치
    var markerPosition = new kakao.maps.LatLng(33.450701, 126.570667);
    // 마커 생성
    var marker = new kakao.maps.Marker({
        position: markerPosition
    });
    // 마커가 지도 위에 표시되도록 설정
    marker.setMap(map)

    let geocoder = new kakao.maps.services.Geocoder();
    let address = '제주특별자치도 제주시 첨단로 242';
    geocoder.addressSearch(address, function (result, status){
        if (status === kakao.maps.services.Status.OK) {
// 배열의 첫번째 위치로 이동
            var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
            var marker = new kakao.maps.Marker({
                map: map,
                position: coords
            });
// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
            map.setCenter(coords);
        }
    });

</script>

<%@include file="../layouts/footer.jsp" %>