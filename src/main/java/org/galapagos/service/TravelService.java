package org.galapagos.service;


import org.galapagos.domain.Criteria;
import org.galapagos.domain.TravelVO;

import java.util.List;

public interface TravelService {
    int getTotal(Criteria criteria);
    List<TravelVO> getList(Criteria criteria);
    TravelVO get(Long no);
    void register(TravelVO travelVO);
    boolean modify(TravelVO travelVO);
    boolean remove(Long no);

}
