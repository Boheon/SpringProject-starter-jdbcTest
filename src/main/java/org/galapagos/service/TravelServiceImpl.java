package org.galapagos.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.galapagos.domain.Criteria;
import org.galapagos.domain.TravelVO;
import org.galapagos.mapper.TravelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j
@Service //빈 등록
@AllArgsConstructor //생성자 추가로 Autowired
public class TravelServiceImpl implements TravelService{

    private TravelMapper mapper;

    @Override
    public int getTotal(Criteria criteria) {
        return mapper.getTotalCount(criteria);
    }

    @Override
    public List<TravelVO> getList(Criteria criteria) {
        return mapper.getList(criteria);
    }

    @Override
    public TravelVO get(Long no) {
        //조회수 처리

        return mapper.read(no);
    }

    @Override
    public void register(TravelVO travelVO) {
        mapper.insert(travelVO);

        //첨부파일 업로드
    }

    @Override
    public boolean modify(TravelVO travelVO) {
        return mapper.update(travelVO) == 1;
    }

    @Override
    public boolean remove(Long no) {
        return mapper.delete(no) == 1;
    }
}
