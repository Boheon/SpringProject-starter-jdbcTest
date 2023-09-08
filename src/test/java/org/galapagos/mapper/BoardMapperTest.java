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
      if(list.isEmpty()){
          log.info("list가 비었잖아");
      }
      for(BoardVO boardVO : list){

          log.info(boardVO);
      }
    }
}