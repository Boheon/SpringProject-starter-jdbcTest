package org.galapagos.mapper;


import org.galapagos.domain.BoardVO;
import org.apache.ibatis.annotations.Select;
import org.galapagos.domain.Criteria;

import java.util.List;

public interface BoardMapper {
//    xml로 대체
//    @Select("select * from tbl_board")

    public int getTotalCount(Criteria cri);

    List<BoardVO> getList();

    List<BoardVO> getListWithPaging(Criteria cri);

    void insert(BoardVO boardVO);//insert 후에 bno를 모름

    void insertSelectKey(BoardVO boardVO);//insert 후에 bno도 추출한다.

    BoardVO read(Long bno);//상세보기

    int delete(Long bno);//삭제

    int update(BoardVO boardVO);//업데이트
}