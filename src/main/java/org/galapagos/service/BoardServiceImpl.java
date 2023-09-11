package org.galapagos.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.galapagos.domain.BoardVO;
import org.galapagos.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service //빈 등록
@AllArgsConstructor //생성자 추가로 Autowired
public class BoardServiceImpl implements BoardService {
    //@Autowired
    private BoardMapper mapper; //생성자의 매개변수로 쓰임


    @Override
    public void register(BoardVO board) {
        log.info("register......." + board);
        mapper.insertSelectKey(board);
    }

    @Override
    public BoardVO get(Long bno) {
        log.info("get...............");

        return mapper.read(bno);
    }

    @Override
    public boolean modify(BoardVO board) {
        log.info("modify......" + board);
        return mapper.update(board) == 1;
    }

    @Override
    public boolean remove(Long bno) {
        log.info("remove...." + bno);
        return mapper.delete(bno) == 1;
    }

    @Override
    public List<BoardVO> getList()
    {
        log.info("getList................");
        return mapper.getList();
    }
}
