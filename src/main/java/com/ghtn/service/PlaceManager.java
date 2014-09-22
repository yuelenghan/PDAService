package com.ghtn.service;

import com.ghtn.model.oracle.Place;
import com.ghtn.vo.PlaceAreaVO;
import com.ghtn.vo.PlaceVO;

import java.util.List;

/**
 * Created by lihe on 14/9/15.
 */
public interface PlaceManager extends GenericManager<Place, Integer> {

    List<PlaceAreaVO> getAreasOracleDataSource3(String mainDeptId);

    List<PlaceVO> getPlacesOracleDataSource3(int areaId);
}
