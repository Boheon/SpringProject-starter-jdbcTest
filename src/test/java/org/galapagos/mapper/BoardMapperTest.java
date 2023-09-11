package org.galapagos.mapper;

import java.util.List;

import org.galapagos.config.RootConfig;
import org.galapagos.domain.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class BoardMapperTest {

    @Autowired
    private BoardMapper mapper;

    @Test
    public void getList() {
        List<BoardVO> list = mapper.getList();
        if (list.isEmpty()) {
            log.info("list가 비었잖아");
        }
        for (BoardVO boardVO : list) {

            log.info(boardVO);
        }
    }

    @Test
    public void testInsert() {
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("newbie");

        //mapper.insert(board);//bno=null
        mapper.insertSelectKey(board);//bno입력됨

        log.info(board);
    }

    @Test
    public void testRead() {
        //존재하는 게시물 번호로 테스트
        BoardVO board = mapper.read(5L);

        log.info(board);
    }

    @Test
    public void testDelete() {
        log.info("Delete Count: " + mapper.delete(3L));
    }

    @Test
    public void testUpdate() {
        BoardVO board = new BoardVO();
        board.setBno(5L);
        board.setTitle("수정된 제목");
        board.setContent("수정된 내용");
        board.setWriter("user00");
        int count = mapper.update(board);
        log.info("UPDATE COUNT: " + count);
    }
}