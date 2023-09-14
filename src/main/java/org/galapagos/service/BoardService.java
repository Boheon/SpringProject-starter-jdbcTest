package org.galapagos.service;

import org.galapagos.domain.BoardVO;
import org.galapagos.domain.Criteria;

import java.util.List;

public interface BoardService {
    int getTotal(Criteria criteria);
    void register(BoardVO board);
    BoardVO get(Long bno);
    boolean modify(BoardVO board);
    boolean remove(Long bno);
    List<BoardVO> getList(Criteria criteria);
}
