package org.galapagos.service;

import lombok.extern.log4j.Log4j;
import org.galapagos.config.RootConfig;
import org.galapagos.domain.BoardVO;
import org.galapagos.domain.Criteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
public class BoardServiceTest {

    @Autowired
    private BoardService service;

    //@Test
    public void register() {
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성한 내용");
        board.setWriter("newbie");

        service.register(board);
        log.info("생성된 게시물의 번호: " + board.getBno());
    }

    //@Test
    public void get() {
        log.info(service.get(1L));
    }

    //@Test
    public void modify() {
        BoardVO board = service.get(1L);
        if (board == null) {
            return;
        }
        board.setTitle("제목 수정합니다.");
        log.info("MODIFY RESULT: " + service.modify(board));
    }

   // @Test
    public void remove() {
        // 게시물 번호의 존재 여부를 확인하고 테스트할 것
        log.info("REMOVE RESULT: " + service.remove(2L));
    }

//    @Test
//    public void testGetList(){
//        for(BoardVO boardVO : service.getList()){
//            log,info(boardVO);
//        }
//    }

    @Test
    public void testGetList(){
        List<BoardVO> list = service.getList(new Criteria(2, 10));

        for(BoardVO boardVO : list){
            log.info(boardVO);
        }
    }


}