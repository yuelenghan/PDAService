package com.ghtn.dao;

import com.ghtn.model.oracle.Place;
import com.ghtn.model.oracle.Placeareas;

import java.util.List;

/**
 * Created by lihe on 14/9/15.
 */
public interface PlaceDao extends GenericDao<Place, Integer> {

    List<Placeareas> getAreas(String mainDeptId);

    List<Place> getPlace(int areaId);
}
