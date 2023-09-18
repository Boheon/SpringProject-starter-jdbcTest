$(document).ready(function () {
    let actionForm = $('#actionForm');

    $('a.page-link').on('click', function (e) {
        e.preventDefault();	// 해당 태그의 디폴트 액션 실행 막음
        actionForm.find('input[name="pageNum"]')
            .val($(this).attr('href'));
        actionForm.submit();
    });

    $('.move').on('click', function (e) {
        e.preventDefault();
        actionForm.append('<input type="hidden" name="bno"/>');
        actionForm.find('input[name="bno"]')
            .val($(this).attr('href'));
        actionForm.attr('action', '/board/get');
        actionForm.submit();
    });
});