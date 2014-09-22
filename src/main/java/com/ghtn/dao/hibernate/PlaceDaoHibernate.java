package com.ghtn.dao.hibernate;

import com.ghtn.dao.PlaceDao;
import com.ghtn.model.oracle.Place;
import com.ghtn.model.oracle.Placeareas;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lihe on 14/9/15.
 */
@Repository("placeDao")
public class PlaceDaoHibernate extends GenericDaoHibernate<Place, Integer> implements PlaceDao {

    public PlaceDaoHibernate() {
        super(Place.class);
    }

    @Override
    public List<Placeareas> getAreas(String mainDeptId) {
        return getSession().createCriteria(Placeareas.class)
                .add(Restrictions.eq("maindeptid", mainDeptId))
                .addOrder(Order.asc("pareasid")).list();
    }

    @Override
    public List<Place> getPlace(int areaId) {
        return getSession().createCriteria(Place.class)
                .add(Restrictions.eq("pareasid", areaId))
                .addOrder(Order.asc("placeid")).list();
    }
}
