package org.galapagos.mapper;


import org.galapagos.domain.BoardVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BoardMapper {
//    xml로 대체
//    @Select("select * from tbl_board")
    public List<BoardVO> getList();
}