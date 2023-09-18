package org.galapagos.mapper;

import lombok.extern.log4j.Log4j;
import org.galapagos.config.RootConfig;
import org.galapagos.domain.BoardVO;
import org.galapagos.domain.Criteria;
import org.galapagos.domain.TravelVO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Log4j
class TravelMapperTest {

    @Autowired
    private TravelMapper mapper;

    @Test
    void getTotalCount() {
        Criteria cri = new Criteria();//검색어 없는 상태

        int total = mapper.getTotalCount(cri);
        log.info("total : " + total);

        cri.setType("RTD");
        cri.setKeyword("해수욕장");
        total = mapper.getTotalCount(cri);
        log.info("total : " + total);
    }

    @Test
    void getList() {
        Criteria cri = new Criteria();
        List<TravelVO> list = mapper.getList(cri);
        for (TravelVO travelVO : list) {
            log.info(travelVO);
        }

        //검색
        cri.setType("RTD");
        cri.setKeyword("해수욕장");
        for (TravelVO travelVO : list) {
            log.info(travelVO);
        }
    }

    @Test
    void insert() {
        TravelVO travelVO = new TravelVO();
        travelVO.setRegion("수도권");
        travelVO.setTitle("스타필드");
        travelVO.setDescription("백화점");
        travelVO.setAddress("서울시 강남구");
        travelVO.setPhone("1111-2222-3333");

        mapper.insert(travelVO);
        log.info(travelVO);
    }

    @Test
    void read() {
        TravelVO travel = mapper.read(10L);
        log.info(travel);
    }

    @Test
    void delete() {
        mapper.delete(113L);
    }

    @Test
    void update() {
        TravelVO travel = mapper.read(113L);
        travel.setTitle("인청 닭갈비");
        travel.setDescription("맛집");
        travel.setAddress("인천 어디에 있음");
        travel.setPhone("2222-3333-4444");

        int count = mapper.update(travel);

        log.info("UPDATE COUNT : " + count);
    }
}