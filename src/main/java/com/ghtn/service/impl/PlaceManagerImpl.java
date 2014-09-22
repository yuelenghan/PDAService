package com.ghtn.service.impl;

import com.ghtn.dao.PlaceDao;
import com.ghtn.model.oracle.Place;
import com.ghtn.model.oracle.Placeareas;
import com.ghtn.service.PlaceManager;
import com.ghtn.vo.PlaceAreaVO;
import com.ghtn.vo.PlaceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihe on 14/9/15.
 */
@Service("placeManager")
public class PlaceManagerImpl extends GenericManagerImpl<Place, Integer> implements PlaceManager {

    private PlaceDao placeDao;

    @Autowired
    public PlaceManagerImpl(PlaceDao placeDao) {
        super(placeDao);
        this.placeDao = placeDao;
    }


    @Override
    public List<PlaceAreaVO> getAreasOracleDataSource3(String mainDeptId) {
        List<Placeareas> list = placeDao.getAreas(mainDeptId);
        List<PlaceAreaVO> returnList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (Placeareas placeareas : list) {
                PlaceAreaVO vo = new PlaceAreaVO();
                vo.setId(placeareas.getPareasid());
                vo.setName(placeareas.getPareasname());

                returnList.add(vo);
            }
        }
        return returnList;
    }

    @Override
    public List<PlaceVO> getPlacesOracleDataSource3(int areaId) {
        List<Place> list = placeDao.getPlace(areaId);
        List<PlaceVO> returnList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (Place place : list) {
                PlaceVO vo = new PlaceVO();
                vo.setId(place.getPlaceid());
                vo.setName(place.getPlacename());

                returnList.add(vo);
            }
        }
        return returnList;
    }
}
