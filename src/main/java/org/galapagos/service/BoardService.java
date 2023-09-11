package org.galapagos.service;

import org.galapagos.domain.BoardVO;

import java.util.List;

public interface BoardService {
    void register(BoardVO board);
    BoardVO get(Long bno);
    boolean modify(BoardVO board);
    boolean remove(Long bno);
    List<BoardVO> getList();
}
