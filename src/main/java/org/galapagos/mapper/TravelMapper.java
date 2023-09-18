package org.galapagos.mapper;

import org.galapagos.domain.Criteria;
import org.galapagos.domain.TravelVO;

import java.util.List;

public interface TravelMapper {

    public int getTotalCount(Criteria cri);

    //페이지 목록 추출
    List<TravelVO> getList(Criteria cri);

    //pk 추출 포함
    void insert(TravelVO travelVO);

    TravelVO read(Long bno);//상세보기

    int delete(Long bno);//삭제

    int update(TravelVO travelVO);//업데이트
}
